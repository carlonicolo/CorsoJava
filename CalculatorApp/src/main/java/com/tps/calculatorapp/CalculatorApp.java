package com.tps.calculatorapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                CalculatorApp.class.getResource("calculator-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 280, 300);
        stage.setTitle("Calcolatrice JavaFX");
        stage.setScene(scene);
        stage.show();
    }
}
