module mliot.mliotmonitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires com.google.protobuf;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens mliot.monitor to javafx.fxml;
    exports mliot.monitor;
}