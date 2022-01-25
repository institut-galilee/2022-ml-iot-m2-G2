module mliot.mliotmonitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens mliot.mliotmonitor to javafx.fxml;
    exports mliot.mliotmonitor;
}