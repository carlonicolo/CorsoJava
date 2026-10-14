package com.tps;

public class Auto {
    private int cavalli;
    private String marca;
    private String modello;
    private boolean isElectric;

    public Auto(int cavalli, String marca, boolean isElectric){
        this.cavalli = cavalli;
        this.marca = marca;
        this.isElectric = isElectric;
    }

    public int getCavalli() {
        return cavalli;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public boolean isElectric() {
        return isElectric;
    }
}
