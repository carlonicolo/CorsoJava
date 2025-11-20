package Fundamentals;

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

        String operazione = args[0];

        // Converto gli argomenti numerici in array di double
        double[] valori = new double[args.length - 1];
        try {
            for (int i = 1; i < args.length; i++) {
                valori[i - 1] = Double.parseDouble(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Errore: tutti i valori dopo l'operazione devono essere numeri.");
            return;
        }

        // Creo un oggetto Calcolatrice
        Calcolatrice calc = new Calcolatrice(operazione, valori);

        try {
            double risultato = calc.esegui();

            // Stampa del risultato
            System.out.println("Operazione: " + operazione.toLowerCase());
            System.out.print("Valori: ");
            for (int i = 1; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
            System.out.println();
            System.out.println("Risultato = " + risultato);

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

