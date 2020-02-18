package com.company;


public class Motor extends Thread {
    Ascensor ascensor;

    boolean subiendo;
    boolean bajando = false;

    public Motor(Ascensor ascensor) {
        subiendo = true;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        for(;;){
            if (subiendo) {
                if (ascensor.numP <= ascensor.pisoLimite) {
                    if (ascensor.numP == ascensor.pisoLimite) {
                        subiendo = false;
                        bajando = true;

                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ascensor.numP++;
                        ascensor.notificar();
                        System.out.println("SUBIENDO AL PISO " + ascensor.numP);
                    }
                }
            } else if (bajando) {
                if (ascensor.numP >= 0) {
                    if (ascensor.numP == 0) {
                        bajando = false;
                        subiendo = true;

                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ascensor.numP--;
                        ascensor.notificar();
                        System.out.println("BAJANDO AL " + ascensor.numP);
                    }
                }
            }
        }
    }
}