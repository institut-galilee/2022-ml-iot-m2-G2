package mliot.monitor.controller;

import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mliot.monitor.generated.*;
import mliot.monitor.impl.Monitor;
import mliot.monitor.model.Report;
import mliot.monitor.model.Student;
import mliot.monitor.model.Warning;
import mliot.monitor.util.ColorHelper;
import mliot.monitor.util.Util;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private Monitor monitor;

    private static final Logger logger = Logger.getLogger(HomeController.class.getCanonicalName());

    private final String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*
            Load students lists
         */
        this.studentList = Util.loadListOfStudents();

        this.apiUrl.setText(Util.findApiUrl());
        this.examUrl.setText(Util.findExamUrl());

        updateGridView();

        this.monitor = new Monitor(new MonitorServiceGrpc.MonitorServiceImplBase() {
            @Override
            public void fetchKnownStudents(EmptyMessage request, StreamObserver<KnownStudentResponse> responseObserver) {
                logger.log(Level.INFO, "A list of students is requested");
                HomeController.this.studentList.forEach(
                        student -> {
                            byte []image = Util.readImage(student.getCardNumber());
                            if (image != null) {
                                responseObserver.onNext(
                                        KnownStudentResponse.newBuilder()
                                                .setFirstName(student.getFirstName())
                                                .setLastName(student.getLastName())
                                                .setCardNumber(student.getCardNumber())
                                                .setProfilePhoto(ByteString.copyFrom(image))
                                                .build()
                                );
                            }
                        }
                );
                responseObserver.onCompleted();
            }

            @Override
            public void onStudentConnected(StudentConnectionMessage request, StreamObserver<StudentConnectionResponse> responseObserver) {
                Platform.runLater(() -> studentConnected(request.getCardNumber(), request.getAddress(), request.getPortNumber()));
                String examUrl = Util.findExamUrl();
                String apiUrl = Util.findApiUrl();
                responseObserver.onNext(StudentConnectionResponse.newBuilder().setApiUrl(apiUrl).setExamUrl(examUrl).build());
                responseObserver.onCompleted();
            }

            @Override
            public void onMovementDetected(MovementDetectionMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onMicrophoneSpeechRecognized(SpeechRecognitionMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentReport(request.getCardNumber(), request.getSpokenSpeech(), request.getSimilarityReportList(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onBrowserSizeNotFittingScreenSize(BrowserSizeMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onScreenshotTextRecognized(ScreenshotTextRecognitionMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentReport(request.getCardNumber(), request.getRecognizedText(), request.getSimilarityReportList(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onQRCodeVerificationFailed(QRCodeVerificationMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onStudentNotAllowed(StudentFraudMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onFaceNotRecognized(FaceRecognitionMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onWebCameraObjectsRecognized(WebCameraRecognitionMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onPhoneCameraObjectsRecognized(PhoneCameraRecognitionMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onUnAuthorizedMonitor(UnAuthorizedMonitorMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onHighAccelerationNoticed(HighAccelerationMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onHandDeviceStateChanged(HandDeviceMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentMessage(request.getCardNumber(), request.getMessage(), request.getMills(), request.getSeverity()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }

            @Override
            public void onStudentDisconnected(StudentDisconnectionMessage request, StreamObserver<EmptyResponse> responseObserver) {
                Platform.runLater(() -> studentDisconnected(request.getCardNumber()));
                responseObserver.onNext(EmptyResponse.newBuilder().build());
                responseObserver.onCompleted();
            }
        });
        this.monitor.start();
    }

    @FXML
    void onApiSave() {
        if (Pattern.compile(this.regex).matcher(this.apiUrl.getText().trim().toLowerCase()).matches()) {
            Util.saveApiUrl(this.apiUrl.getText().trim().toLowerCase());
        }
    }

    @FXML
    void onUrlSave() {
        if (Pattern.compile(this.regex).matcher(this.examUrl.getText().trim().toLowerCase()).matches()) {
            Util.saveExamUrl(this.examUrl.getText().trim().toLowerCase());
        }
    }

    @FXML
    public void onClickListener(MouseEvent mouseEvent) throws Exception {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
            Node target = (Node) mouseEvent.getTarget();
            if (target != this.gridView) {
                Node parent;
                while ((parent = target.getParent()) != this.gridView) {
                    target = parent;
                }
            }
            Integer rowIndex = GridPane.getRowIndex(target);
            Integer columnIndex = GridPane.getColumnIndex(target);
            if (columnIndex != null && rowIndex != null) {
                showLogDialog(this.studentList.get(((rowIndex - 1) * this.MAX_COLUMN_NUMBER) + columnIndex));
            }
        }
    }

    public void stopProcesses() {
        this.monitor.shutDown();
    }

    private void showLogDialog(Student student)  throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(DialogController.class.getResource("dialog.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            HomeController.this.studentList.forEach(
                    currentStudent -> {
                        if (currentStudent.getCardNumber().equals(student.getCardNumber()) &&
                                !currentStudent.getStatusColor().equals(ColorHelper.COLOR_STUDENT_OFFLINE)) {
                            currentStudent.setStatusColor(ColorHelper.COLOR_STUDENT_ONLINE);
                        }
                    }
            );
            HomeController.this.gridView.getChildren().clear();
            updateGridView();
        });

        DialogController dialogController = fxmlLoader.getController();
        dialogController.setStudent(student);
        stage.showAndWait();
    }

    private void studentConnected(String cardNumber, String address, int portNumber) {
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

    private void studentMessage(String cardNumber, String message, long mills, Severity severity) {
        this.studentList.forEach(
                student -> {
                    if (student.getCardNumber().equals(cardNumber)) {
                        Date date = new Date(mills);
                        Warning warning = new Warning();
                        warning.setDate(this.dateFormat.format(date));
                        warning.setMessage(message);
                        warning.setSeverity(severity);
                        student.addWarning(warning);
                        changeStatusColor(severity, student);
                    }
                }
        );
        this.gridView.getChildren().clear();
        updateGridView();
    }

    private void studentReport(String cardNumber, String spokenSpeech, ProtocolStringList similarityReportList, long mills, Severity severity) {
        this.studentList.forEach(
                student -> {
                    if (student.getCardNumber().equals(cardNumber)) {
                        Date date = new Date(mills);
                        Report report = new Report();
                        report.setDate(this.dateFormat.format(date));
                        report.setSeverity(severity);
                        report.setRecognizedText(spokenSpeech);
                        report.setSimilarityReport(Lists.newArrayList(similarityReportList.iterator()));
                        student.addReport(report);
                        changeStatusColor(severity, student);
                    }
                }
        );
        this.gridView.getChildren().clear();
        updateGridView();
    }

    private void changeStatusColor(Severity severity, Student student) {
        switch (severity) {
            case NORMAL -> {
                if (student.getStatusColor().equals(ColorHelper.COLOR_STUDENT_OFFLINE)) {
                    student.setStatusColor(ColorHelper.COLOR_STUDENT_ONLINE);
                }
            }
            case WARNING -> {
                if (!student.getStatusColor().equals(ColorHelper.COLOR_STUDENT_SEVERE)) {
                    student.setStatusColor(ColorHelper.COLOR_STUDENT_WARNING);
                }
            }
            case SEVERE -> student.setStatusColor(ColorHelper.COLOR_STUDENT_SEVERE);
        }
    }

    private void studentDisconnected(String cardNumber) {
        this.studentList.forEach(
                student -> {
                    if (student.getCardNumber().equals(cardNumber)) {
                        student.setStatusColor(ColorHelper.COLOR_STUDENT_OFFLINE);
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
                    FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("student.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    anchorPane.setId(student.getCardNumber());
                    anchorPane.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 5", student.getStatusColor()));

                    StudentController studentController = fxmlLoader.getController();
                    studentController.setStudent(student);

                    if (column == this.MAX_COLUMN_NUMBER) {
                        column = 0;
                        row++;
                    }

                    this.gridView.add(anchorPane, column++, row);

                    this.gridView.setMinWidth(Region.USE_COMPUTED_SIZE);
                    this.gridView.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    this.gridView.setMaxWidth(Region.USE_PREF_SIZE);

                    this.gridView.setMinHeight(Region.USE_COMPUTED_SIZE);
                    this.gridView.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    this.gridView.setMaxHeight(Region.USE_PREF_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(10));
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while populating list of students inside the gridView", e);
        }
    }
}
