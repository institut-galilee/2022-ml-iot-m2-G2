package mliot.monitor.controller;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mliot.monitor.MainApplication;
import mliot.monitor.generated.FeedbackMessage;
import mliot.monitor.generated.SinkServiceGrpc;
import mliot.monitor.model.Report;
import mliot.monitor.model.Student;
import mliot.monitor.model.Warning;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DialogController {

    @FXML
    private Label lastName;
    @FXML
    private Label firstName;
    @FXML
    private Label cardNumber;
    @FXML
    private Label messageLabel;
    @FXML
    private TextArea messageArea;
    @FXML
    private ImageView profilePhoto;
    @FXML
    private TableColumn<Report, String> reportDate;
    @FXML
    private TableColumn<Report, String> reportExtracted;
    @FXML
    private TableColumn<Report, String> reportSimilarity;
    @FXML
    private TableColumn<Warning, String> warningDate;
    @FXML
    private TableColumn<Warning, String> warningMessage;
    @FXML
    private TableView<Warning> warningTableView;
    @FXML
    private TableView<Report> reportTableView;

    private Student student;

    @FXML
    void onClearButtonClicked(ActionEvent event) {
        this.messageArea.clear();
    }

    @FXML
    void onSendButtonClicked(ActionEvent event) {
        if (!this.messageArea.getText().trim().isEmpty()) {
            String message = this.messageArea.getText().trim();
            this.messageArea.clear();
            new Thread(() -> {
                try {
                    ManagedChannel channel = ManagedChannelBuilder.forAddress(student.getAddress(), student.getPortNumber()).usePlaintext().build();
                    SinkServiceGrpc.SinkServiceBlockingStub stub = SinkServiceGrpc.newBlockingStub(channel);
                    FeedbackMessage feedbackMessage = FeedbackMessage.newBuilder().setMessage(message).build();
                    stub.onMonitorFeedbackAvailable(feedbackMessage);
                    channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    public void setStudent(Student student) {
        this.student = student;
        this.lastName.setText(this.student.getLastName());
        this.firstName.setText(this.student.getFirstName());
        this.cardNumber.setText(this.student.getCardNumber());
        InputStream stream = MainApplication.class.getResourceAsStream(String.format(Locale.getDefault(), "asset/images/%s.jpg", this.student.getCardNumber()));
        if (stream != null) {
            this.profilePhoto.setImage(new Image(stream));
        }
        this.profilePhoto.getParent().setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 5", this.student.getStatusColor()));
        this.messageLabel.setText(String.format("Message à %s %s", this.student.getFirstName(), this.student.getLastName()));

        warningDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        warningMessage.setCellValueFactory(new PropertyValueFactory<>("message"));

        List<Warning> warningList = new ArrayList<>(this.student.getWarningLog());
        Collections.reverse(warningList);
        ObservableList<Warning> warningObservableList = FXCollections.observableArrayList();
        warningObservableList.addAll(warningList);
        this.warningTableView.setItems(warningObservableList);

        reportDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        reportExtracted.setCellValueFactory(new PropertyValueFactory<>("recognizedText"));
        reportSimilarity.setCellValueFactory(new PropertyValueFactory<>("similarityReport"));

        List<Report> reportList = new ArrayList<>(this.student.getReportLog());
        Collections.reverse(reportList);
        ObservableList<Report> reportObservableList = FXCollections.observableArrayList();
        reportObservableList.addAll(reportList);
        this.reportTableView.setItems(reportObservableList);
    }
}