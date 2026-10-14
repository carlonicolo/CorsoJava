package com.tps;

public class Moto {
    private String marca;
    private int num_cavalli;
    private String colore;
    private double cilindrata;

    public Moto(String marca, int num_cavalli, String colore, double cilindrata)
    {
        this.marca = marca;
        this.num_cavalli = num_cavalli;
        this.colore = colore;
        this.cilindrata = cilindrata;
    }

    public Moto(String marca, int num_cavalli, double cilindrata)
    {
        this.marca = marca;
        this.num_cavalli = num_cavalli;
        this.cilindrata = cilindrata;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public int getNum_cavalli(){
        return num_cavalli;
    }

    public void setNum_cavalli(int num_cavalli){
        this.num_cavalli = num_cavalli;
    }



}
