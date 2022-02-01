package mliot.monitor.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import mliot.monitor.MainApplication;
import mliot.monitor.callback.HomeControllerCallback;
import mliot.monitor.util.Util;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController implements Initializable {

    @FXML
    public GridPane gridView;

    private List<JsonElement> studentList;
    private final int MAX_COLUMN_NUMBER = 3;

    private HomeControllerCallback homeControllerCallback;

    private static final Logger logger = Logger.getLogger(MainApplication.class.getCanonicalName());

    public void setHomeControllerCallback(HomeControllerCallback homeControllerCallback) {
        this.homeControllerCallback = homeControllerCallback;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 1;
        int column = 0;
        try {
            this.studentList = Util.loadListOfStudents();
            if (this.studentList != null) {
                for (JsonElement jsonElement : this.studentList) {
                    JsonObject studentObject = jsonElement.getAsJsonObject();
                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("item.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    anchorPane.setStyle("-fx-background-color: #fff; -fx-background-radius: 5");

                    ItemController itemController = fxmlLoader.getController();
                    itemController.setStudent(studentObject);

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

    @FXML
    public void onClickListener(MouseEvent mouseEvent) {
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
            this.homeControllerCallback.onStudentRequested(this.studentList.get(((rowIndex - 1) * MAX_COLUMN_NUMBER) + columnIndex).getAsJsonObject());
        }
    }
}
