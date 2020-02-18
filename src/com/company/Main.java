package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Ascensor ascensor = new Ascensor(10);

        Motor motor = new Motor(ascensor);

        List<Persona> personas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            int numEntrada = (int)(Math.random()*4+1);
            int numSalida = numEntrada + (int)(Math.random()*6+1);

            Persona persona = new Persona("Persona " + (i+1), ascensor, numEntrada, numSalida);
            personas.add(persona);

        }

        for (Persona p: personas) {
            p.start();
        }

        motor.start();

    }
}
