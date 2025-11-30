module com.tps.calculatorapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.tps.calculatorapp to javafx.fxml;
    exports com.tps.calculatorapp;
}