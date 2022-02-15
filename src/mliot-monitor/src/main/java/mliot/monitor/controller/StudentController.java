package mliot.monitor.controller;

import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mliot.monitor.MainApplication;
import mliot.monitor.model.Student;
import mliot.monitor.util.Util;

import java.io.InputStream;
import java.util.Locale;

public class StudentController {

    @FXML
    public Label nameView;
    @FXML
    public Label numberView;
    @FXML
    public ImageView imageView;

    public void setStudent(JsonObject studentObject) {
        if ((studentObject.has(Util.STUDENT_FIRST_NAME) && !studentObject.get(Util.STUDENT_FIRST_NAME).isJsonNull()) &&
                (studentObject.has(Util.STUDENT_LAST_NAME) && !studentObject.get(Util.STUDENT_LAST_NAME).isJsonNull())){
            this.nameView.setText(String.format(Locale.getDefault(), "%s %s", studentObject.get(Util.STUDENT_FIRST_NAME).getAsString(), studentObject.get(Util.STUDENT_LAST_NAME).getAsString()));
        }

        if (studentObject.has(Util.STUDENT_CARD_NUMBER) && !studentObject.get(Util.STUDENT_CARD_NUMBER).isJsonNull()){
            this.numberView.setText(studentObject.get(Util.STUDENT_CARD_NUMBER).getAsString());
            InputStream stream = MainApplication.class.getResourceAsStream(String.format(Locale.getDefault(), "asset/images/%s.jpg", studentObject.get(Util.STUDENT_CARD_NUMBER).getAsString()));
            if (stream != null) {
                this.imageView.setImage(new Image(stream));
            }
        }
    }

    public void setStudent(Student student) {
        this.nameView.setText(String.format(Locale.getDefault(), "%s %s", student.getFirstName(), student.getLastName()));
        this.numberView.setText(student.getCardNumber());
        InputStream stream = MainApplication.class.getResourceAsStream(String.format(Locale.getDefault(), "asset/images/%s.jpg", student.getCardNumber()));
        if (stream != null) {
            this.imageView.setImage(new Image(stream));
        }
    }
}
