package com.tps.calculatorapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    private void initialize() {
        display.setText("0");
    }

    @FXML
    private void handleButton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String text = btn.getText();

        switch (text) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                handleNumber(text);
                break;
            case "+": case "-": case "*": case "/":
                handleOperator(text);
                break;
            case "=":
                handleEquals();
                break;
            case "C":
                handleClear();
                break;
        }
    }

    private void handleNumber(String digit) {
        if (startNewNumber || display.getText().equals("0") || display.getText().equals("Errore")) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    private void handleOperator(String op) {
        try {
            firstOperand = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            firstOperand = 0;
        }
        operator = op;
        startNewNumber = true;
    }

    private void handleEquals() {
        if (operator.isEmpty()) {
            return;
        }

        double secondOperand;
        try {
            secondOperand = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            secondOperand = 0;
        }

        double result = 0;
        boolean error = false;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand == 0) {
                    display.setText("Errore");
                    error = true;
                } else {
                    result = firstOperand / secondOperand;
                }
                break;
        }

        if (!error) {
            if (result == (long) result) {
                display.setText(String.valueOf((long) result));
            } else {
                display.setText(String.valueOf(result));
            }
        }

        operator = "";
        startNewNumber = true;
    }

    private void handleClear() {
        display.setText("0");
        firstOperand = 0;
        operator = "";
        startNewNumber = true;
    }
}
