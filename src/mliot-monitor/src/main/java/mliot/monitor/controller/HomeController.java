package mliot.monitor.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import mliot.monitor.MainApplication;
import mliot.monitor.util.Util;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController implements Initializable {

    @FXML
    public GridPane gridview;
    private static final Logger logger = Logger.getLogger(MainApplication.class.getCanonicalName());

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 1;
        int column = 0;
        try {
            JsonArray studentArray = Util.loadArrayOfStudents();
            if (studentArray != null) {
                for (int i = 0; i < studentArray.size(); i++) {
                    JsonObject studentObject = studentArray.get(i).getAsJsonObject();
                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("item.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();

                    ItemController itemController = fxmlLoader.getController();
                    itemController.setStudent(studentObject);

                    if (column == 3) {
                        column = 0;
                        row++;
                    }

                    gridview.add(anchorPane, column++, row);

                    gridview.setMinWidth(Region.USE_COMPUTED_SIZE);
                    gridview.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    gridview.setMaxWidth(Region.USE_PREF_SIZE);

                    gridview.setMinHeight(Region.USE_COMPUTED_SIZE);
                    gridview.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    gridview.setMaxHeight(Region.USE_PREF_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(10));
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while populating list of students inside the gridview", e);
        }
    }

}
