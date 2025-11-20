package AdvancedThread;

public class CalcolatriceMain {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso:");
            System.out.println("  java CalcolatriceMain somma num1 num2 [num3 ...]");
            System.out.println("  java CalcolatriceMain moltiplica num1 num2 [num3 ...]");
            System.out.println("  java CalcolatriceMain sottrai num1 num2 [num3 ...]");
            System.out.println("  java CalcolatriceMain dividi num1 num2 [num3 ...]");
            System.out.println("  java CalcolatriceMain media num1 num2 [num3 ...]");
            return;
        }

        String opString = args[0];

        // Converto valori numerici
        double[] valori = new double[args.length - 1];
        try {
            for (int i = 1; i < args.length; i++) {
                valori[i - 1] = Double.parseDouble(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Errore: tutti i valori dopo l'operazione devono essere numeri.");
            return;
        }

        // Creo gli oggetti del "modello"
        Operation operation;
        try {
            operation = Operation.fromString(opString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        CalculationRequest request = new CalculationRequest(operation, valori);
        Calculator calculator = new Calculator();

        // Creo un task e un Thread
        CalculationTask task = new CalculationTask("Task-1", calculator, request);
        Thread t = new Thread(task);

        System.out.println("Avvio del thread di calcolo...");
        t.start();

        // Aspetto che il thread finisca (così il programma non termina subito)
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto: " + e.getMessage());
        }

        System.out.println("Programma terminato.");
    }
}
