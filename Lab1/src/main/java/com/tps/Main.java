package com.tps;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        System.out.println("Creo l'oggetto Auto");
        Auto auto1 = new Auto(80, "BMW", false);
        System.out.println("cavalli = " + auto1.getCavalli());
        */

        System.out.println("Creo l'oggetto Moto");
        Moto cbr = new Moto("Honda", 170, "bianco", 995.5 );

        System.out.println(cbr);
        System.out.println("La marca dell'oggetto cbr è: " + cbr.getMarca());

        cbr.setMarca("Kawasaki");
        System.out.println("La marca dell'oggetto cbr è: " + cbr.getMarca());

        Moto gsxr = new Moto("Suzuki", 182,"bianco ed azzurro", 998.5);
        System.out.println("La marca dell'oggetto gsxr è: " + gsxr.getMarca());



    }
}