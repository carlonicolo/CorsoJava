package AdvancedThread;

public enum Operation {
    SOMMA,
    MOLTIPLICA,
    SOTTRAI,
    DIVIDI,
    MEDIA;

    public static Operation fromString(String op) {
        switch (op.toLowerCase()) {
            case "somma":
                return SOMMA;
            case "moltiplica":
                return MOLTIPLICA;
            case "sottrai":
                return SOTTRAI;
            case "dividi":
                return DIVIDI;
            case "media":
                return MEDIA;
            default:
                throw new IllegalArgumentException("Operazione non valida: " + op);
        }
    }
}

