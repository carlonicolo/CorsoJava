package AdvancedThread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CalcolatriceExecutorMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Creo alcune richieste come prima
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
                Operation.DIVIDI,
                new double[]{100, 2, 5}
        );

        // Creo un pool di 2 thread
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Creo i Callable
        CalculationCallable c1 = new CalculationCallable("Job-1", calculator, r1);
        CalculationCallable c2 = new CalculationCallable("Job-2", calculator, r2);
        CalculationCallable c3 = new CalculationCallable("Job-3", calculator, r3);
        CalculationCallable c4 = new CalculationCallable("Job-4", calculator, r4);

        try {
            // Li invio tutti al pool, che li eseguirà con 2 thread
            List<Future<Double>> futures = executor.invokeAll(
                    Arrays.asList(c1, c2, c3, c4)
            );

            // Recupero i risultati in ordine di invio
            int i = 1;
            for (Future<Double> future : futures) {
                try {
                    Double result = future.get(); // attende il risultato
                    System.out.println("Risultato job " + i + " = " + result);
                } catch (ExecutionException e) {
                    System.out.println("Errore nel job " + i + ": " + e.getCause());
                }
                i++;
            }

        } catch (InterruptedException e) {
            System.out.println("Esecuzione interrotta: " + e.getMessage());
        } finally {
            executor.shutdown(); // molto importante!
        }

        System.out.println("Programma terminato (ExecutorService).");
    }
}
