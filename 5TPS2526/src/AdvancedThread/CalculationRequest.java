package AdvancedThread;

import java.util.Arrays;

public class CalculationRequest {

    private Operation operation;
    private double[] values;

    public CalculationRequest(Operation operation, double[] values) {
        this.operation = operation;
        this.values = values;
    }

    public Operation getOperation() {
        return operation;
    }

    public double[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Operazione: " + operation +
                ", valori: " + Arrays.toString(values);
    }
}
