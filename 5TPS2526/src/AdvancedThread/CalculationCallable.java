package AdvancedThread;

import java.util.concurrent.Callable;

public class CalculationCallable implements Callable<Double> {

    private String taskName;
    private Calculator calculator;
    private CalculationRequest request;

    public CalculationCallable(String taskName, Calculator calculator, CalculationRequest request) {
        this.taskName = taskName;
        this.calculator = calculator;
        this.request = request;
    }

    @Override
    public Double call() throws Exception {
        System.out.println("[" + taskName + "] Inizio calcolo: " + request);
        double result = calculator.calculate(request);
        System.out.println("[" + taskName + "] Fine calcolo");
        return result;
    }
}

