package mliot.monitor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mliot.monitor.MainApplication;
import mliot.monitor.model.Student;

import java.io.InputStream;
import java.util.Locale;

public class StudentController {

    @FXML
    public Label nameView;
    @FXML
    public Label numberView;
    @FXML
    public ImageView imageView;

    public void setStudent(Student student) {
        this.nameView.setText(String.format(Locale.getDefault(), "%s %s", student.getFirstName(), student.getLastName()));
        this.numberView.setText(student.getCardNumber());
        InputStream stream = MainApplication.class.getResourceAsStream(String.format(Locale.getDefault(), "asset/images/%s.jpg", student.getCardNumber()));
        if (stream != null) {
            this.imageView.setImage(new Image(stream));
        }
    }
}
