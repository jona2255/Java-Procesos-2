package com.company;

public class Persona extends Thread {

    String nom;
    Ascensor ascensor;
    int numPisoEntrada;
    int numPisoSalida;

    public Persona(String nom, Ascensor ascensor, int numPisoEntrada, int numPisoSalida) {
        this.nom = nom;
        this.ascensor = ascensor;
        this.numPisoEntrada = numPisoEntrada;
        this.numPisoSalida = numPisoSalida;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        for(;;){
            ascensor.entrar(numPisoEntrada);
            System.out.println(getNom() + " acaba de entrar al ascensor | " + "Nº Personas en el ascensor: " + ascensor.getCont());

            ascensor.salir(numPisoSalida);
            System.out.println(getNom() + " acaba de salir del ascensor | " + "Nº Personas  en el ascensor: " + ascensor.getCont());
        }
    }
}