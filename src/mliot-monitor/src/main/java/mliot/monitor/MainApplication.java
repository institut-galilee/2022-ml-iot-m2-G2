package mliot.monitor;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mliot.monitor.generated.*;
import mliot.monitor.impl.Monitor;
import mliot.monitor.util.Util;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainApplication extends Application {

    private Monitor monitor;
    private JsonArray studentArray;
    private static final Logger logger = Logger.getLogger(MainApplication.class.getCanonicalName());

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        URL cssUrl = MainApplication.class.getResource("styles.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }
        stage.setTitle("MLIoT Monitor");
        stage.setScene(scene);
        stage.show();

        /*
            Load students lists
         */
        studentArray = Util.loadListOfStudents();

        this.monitor = new Monitor(new MonitorServiceGrpc.MonitorServiceImplBase() {
            @Override
            public void fetchKnownStudents(EmptyMessage request, StreamObserver<KnownStudentResponse> responseObserver) {
                logger.log(Level.INFO, "A list of students is requested");
                studentArray.forEach(
                        studentElement -> {
                            JsonObject studentObject = studentElement.getAsJsonObject();
                            byte []image = Util.readImage(studentObject.get(Util.STUDENT_CARD_NUMBER).getAsString());
                            if (image != null) {
                                responseObserver.onNext(
                                        KnownStudentResponse.newBuilder()
                                                .setFirstName(studentObject.get(Util.STUDENT_FIRST_NAME).getAsString())
                                                .setLastName(studentObject.get(Util.STUDENT_LAST_NAME).getAsString())
                                                .setCardNumber(studentObject.get(Util.STUDENT_CARD_NUMBER).getAsString())
                                                .setProfilePhoto(ByteString.copyFrom(image))
                                                .build()
                                );
                            }
                        }
                );
                responseObserver.onCompleted();
            }

            @Override
            public void onMovementDetected(MovementDetectionMessage request, StreamObserver<MonitorResponse> responseObserver) {
                responseObserver.onNext(MonitorResponse.newBuilder().setIsReceived(true).build());
                responseObserver.onCompleted();
            }
        });
        this.monitor.start();
    }

    @Override
    public void stop() {
        this.monitor.shutDown();
    }

    // --module-path /opt/javafx-sdk-17.0.2/lib/ --add-modules=javafx.controls,javafx.fxml
    public static void main(String[] args) {
        launch(args);
    }
}
