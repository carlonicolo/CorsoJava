package AdvancedThread;

public class CalcolatriceMultiThreadMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Creo alcune richieste diverse
        CalculationRequest r1 = new CalculationRequest(
                Operation.SOMMA,
                new double[]{10, 20, 30}
        );

        CalculationRequest r2 = new CalculationRequest(
                Operation.MOLTIPLICA,
                new double[]{2, 3, 4}
        );

        CalculationRequest r3 = new CalculationRequest(
                Operation.MEDIA,
                new double[]{5, 10, 15, 20}
        );

        CalculationRequest r4 = new CalculationRequest(
                Operation.SOTTRAI,
                new double[]{50, 5, 10}
        );

        // Creo un task e un thread per ciascuna richiesta
        Thread t1 = new Thread(new CalculationTask("Task-1", calculator, r1));
        Thread t2 = new Thread(new CalculationTask("Task-2", calculator, r2));
        Thread t3 = new Thread(new CalculationTask("Task-3", calculator, r3));
        Thread t4 = new Thread(new CalculationTask("Task-4", calculator, r4));

        System.out.println("Avvio di tutti i thread...");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Aspetto che tutti finiscano
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrotto: " + e.getMessage());
        }

        System.out.println("Tutti i calcoli sono terminati.");
    }
}

