package AdvancedThread;

public class CalculationTask implements Runnable {

    private String taskName;
    private Calculator calculator;
    private CalculationRequest request;

    public CalculationTask(String taskName, Calculator calculator, CalculationRequest request) {
        this.taskName = taskName;
        this.calculator = calculator;
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println("[" + taskName + "] Inizio calcolo: " + request);
        try {
            double result = calculator.calculate(request);
            System.out.println("[" + taskName + "] Risultato = " + result);
        } catch (Exception e) {
            System.out.println("[" + taskName + "] Errore: " + e.getMessage());
        }
        System.out.println("[" + taskName + "] Fine calcolo");
    }
}
