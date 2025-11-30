module com.tps.labjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.tps.labjavafx to javafx.fxml;
    exports com.tps.labjavafx;
}