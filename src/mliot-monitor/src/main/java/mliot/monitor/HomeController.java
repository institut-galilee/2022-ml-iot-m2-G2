package mliot.monitor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mliot.monitor.util.Util;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText(String.format(Locale.getDefault(), "gRPC Monitoring Server is running at %s:%d", Util.getIpAddress(), Util.MONITOR_PORT_NUMBER));
    }

    @FXML
    protected void onHelloButtonClick() {
        label.setText("Welcome to JavaFX Application!");
    }
}
