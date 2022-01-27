package mliot.monitor;

import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mliot.monitor.generated.*;
import mliot.monitor.impl.Monitor;


public class MainApp extends Application {

    private Monitor monitor;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.show();

        this.monitor = new Monitor(new MonitorServiceGrpc.MonitorServiceImplBase() {
            @Override
            public void onStepDetected(StepDetectionMessage request, StreamObserver<MonitorResponse> responseObserver) {
                responseObserver.onNext(MonitorResponse.newBuilder().setIsReceived(true).build());
                responseObserver.onCompleted();
            }

            @Override
            public void onProximityDetected(ProximityMessage request, StreamObserver<MonitorResponse> responseObserver) {
                responseObserver.onNext(MonitorResponse.newBuilder().setIsReceived(true).build());
                responseObserver.onCompleted();
            }

            @Override
            public void onMotionDetected(MotionDetectionMessage request, StreamObserver<MonitorResponse> responseObserver) {
                responseObserver.onNext(MonitorResponse.newBuilder().setIsReceived(true).build());
                responseObserver.onCompleted();
            }
        });
        this.monitor.start();
    }

    @Override
    public void stop() throws Exception {
        this.monitor.shutDown();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
