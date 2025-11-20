package Fundamentals;

public class Calcolatrice {

    private String operazione;
    private double[] valori;

    public Calcolatrice(String operazione, double[] valori) {
        this.operazione = operazione.toLowerCase();
        this.valori = valori;
    }

    public double esegui() {
        switch (operazione) {
            case "somma":
                return somma();

            case "moltiplica":
                return moltiplica();

            case "sottrai":
                return sottrai();

            case "dividi":
                return dividi();

            case "media":
                return media();

            default:
                throw new IllegalArgumentException(
                        "Operazione non riconosciuta: " + operazione
                );
        }
    }

    // Metodi di istanza, NON statici

    private double somma() {
        double risultato = 0.0;
        for (double v : valori) {
            risultato += v;
        }
        return risultato;
    }

    private double moltiplica() {
        if (valori.length == 0) return 0.0;
        double risultato = 1.0;
        for (double v : valori) {
            risultato *= v;
        }
        return risultato;
    }

    // sottrai: num1 - num2 - num3 - ...
    private double sottrai() {
        if (valori.length == 0) return 0.0;
        double risultato = valori[0];
        for (int i = 1; i < valori.length; i++) {
            risultato -= valori[i];
        }
        return risultato;
    }

    // dividi: num1 / num2 / num3 / ...
    private double dividi() {
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

    private double media() {
        if (valori.length == 0) return 0.0;
        double somma = 0.0;
        for (double v : valori) {
            somma += v;
        }
        return somma / valori.length;
    }

    // Getter opzionali (se ti servono)
    public String getOperazione() {
        return operazione;
    }

    public double[] getValori() {
        return valori;
    }
}


