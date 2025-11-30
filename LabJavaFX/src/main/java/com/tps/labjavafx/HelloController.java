package com.tps.labjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label lblClickMe;

    @FXML
    private Button btnClick;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }


    @FXML
    protected void onBtnClick() {
        lblClickMe.setText("Yeah !!!");
        int somma = Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText());
        lblClickMe.setText(String.valueOf(somma));
    }




    }
