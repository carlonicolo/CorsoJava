package AdvancedThread;

public class Calculator {

    public double calculate(CalculationRequest request) {
        switch (request.getOperation()) {
            case SOMMA:
                return somma(request.getValues());
            case MOLTIPLICA:
                return moltiplica(request.getValues());
            case SOTTRAI:
                return sottrai(request.getValues());
            case DIVIDI:
                return dividi(request.getValues());
            case MEDIA:
                return media(request.getValues());
            default:
                throw new IllegalArgumentException("Operazione non supportata");
        }
    }

    private double somma(double[] valori) {
        double risultato = 0.0;
        for (double v : valori) {
            risultato += v;
        }
        return risultato;
    }

    private double moltiplica(double[] valori) {
        if (valori.length == 0) return 0.0;
        double risultato = 1.0;
        for (double v : valori) {
            risultato *= v;
        }
        return risultato;
    }

    // sottrai: num1 - num2 - num3 - ...
    private double sottrai(double[] valori) {
        if (valori.length == 0) return 0.0;
        double risultato = valori[0];
        for (int i = 1; i < valori.length; i++) {
            risultato -= valori[i];
        }
        return risultato;
    }

    // dividi: num1 / num2 / num3 / ...
    private double dividi(double[] valori) {
        if (valori.length == 0) return 0.0;
        double risultato = valori[0];
        for (int i = 1; i < valori.length; i++) {
            if (valori[i] == 0) {
                throw new ArithmeticException("Divisione per zero");
            }
            risultato /= valori[i];
        }
        return risultato;
    }

    private double media(double[] valori) {
        if (valori.length == 0) return 0.0;
        double somma = 0.0;
        for (double v : valori) {
            somma += v;
        }
        return somma / valori.length;
    }
}
