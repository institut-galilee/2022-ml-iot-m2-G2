package mliot.monitor.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import mliot.monitor.MainApplication;
import mliot.monitor.callback.HomeControllerCallback;
import mliot.monitor.model.Student;
import mliot.monitor.util.ColorHelper;
import mliot.monitor.util.Util;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class HomeController implements Initializable {

    @FXML
    private TextField apiUrl;

    @FXML
    private TextField examUrl;

    @FXML
    public GridPane gridView;

    private List<Student> studentList;
    private final int MAX_COLUMN_NUMBER = 3;

    private HomeControllerCallback homeControllerCallback;

    private static final Logger logger = Logger.getLogger(MainApplication.class.getCanonicalName());

    private final String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public void setHomeControllerCallback(HomeControllerCallback homeControllerCallback) {
        this.homeControllerCallback = homeControllerCallback;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.studentList = Util.loadListOfStudents();

        apiUrl.setText(Util.findApiUrl());
        examUrl.setText(Util.findExamUrl());

        updateGridView();
    }

    @FXML
    void onApiSave() {
        if (Pattern.compile(this.regex).matcher(apiUrl.getText().trim().toLowerCase()).matches()) {
            Util.saveApiUrl(apiUrl.getText().trim().toLowerCase());
        }
    }

    @FXML
    void onUrlSave() {
        if (Pattern.compile(this.regex).matcher(examUrl.getText().trim().toLowerCase()).matches()) {
            Util.saveExamUrl(examUrl.getText().trim().toLowerCase());
        }
    }

    @FXML
    public void onClickListener(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
            Node target = (Node) mouseEvent.getTarget();
            if (target != gridView) {
                Node parent;
                while ((parent = target.getParent()) != gridView) {
                    target = parent;
                }
            }
            Integer rowIndex = GridPane.getRowIndex(target);
            Integer columnIndex = GridPane.getColumnIndex(target);
            if (columnIndex != null && rowIndex != null) {
                this.homeControllerCallback.onStudentRequested(this.studentList.get(((rowIndex - 1) * MAX_COLUMN_NUMBER) + columnIndex));
            }
        }
    }

    public void studentConnected(String cardNumber, String address, int portNumber) {
        this.studentList.forEach(
                student -> {
                    if (student.getCardNumber().equals(cardNumber)) {
                        student.setAddress(address);
                        student.setPortNumber(portNumber);
                        student.setStatusColor(ColorHelper.COLOR_STUDENT_ONLINE);
                    }
                }
        );
        this.gridView.getChildren().clear();
        updateGridView();
    }

    private void updateGridView() {
        int row = 1;
        int column = 0;
        try {
            if (this.studentList != null) {
                for (Student student : this.studentList) {
                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("student.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    anchorPane.setId(student.getCardNumber());
                    anchorPane.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 5", student.getStatusColor()));

                    StudentController studentController = fxmlLoader.getController();
                    studentController.setStudent(student);

                    if (column == MAX_COLUMN_NUMBER) {
                        column = 0;
                        row++;
                    }

                    gridView.add(anchorPane, column++, row);

                    gridView.setMinWidth(Region.USE_COMPUTED_SIZE);
                    gridView.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    gridView.setMaxWidth(Region.USE_PREF_SIZE);

                    gridView.setMinHeight(Region.USE_COMPUTED_SIZE);
                    gridView.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    gridView.setMaxHeight(Region.USE_PREF_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(10));
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while populating list of students inside the gridView", e);
        }
    }
}
