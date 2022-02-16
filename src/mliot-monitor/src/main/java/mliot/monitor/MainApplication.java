package mliot.monitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mliot.monitor.controller.HomeController;
import mliot.monitor.model.Student;

import java.net.URL;
import java.util.List;


public class MainApplication extends Application {

    private List<Student> studentList;

    private HomeController homeController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        URL iconUrl = MainApplication.class.getResource("asset/images/logo.png");
        if (iconUrl != null) {
            stage.getIcons().add(new Image(iconUrl.toExternalForm()));
        }
        stage.setTitle("MLIoT Monitor");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        this.homeController = fxmlLoader.getController();
    }

    @Override
    public void stop() {
        this.homeController.stopProcesses();
    }

    // --module-path /opt/javafx-sdk-17.0.2/lib/ --add-modules=javafx.controls,javafx.fxml
    public static void main(String[] args) {
        launch(args);
    }

}
