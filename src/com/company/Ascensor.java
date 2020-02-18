package com.company;


public class Ascensor {
    int cont = 0;
    int numP = 0;
    int pisoLimite;

    public Ascensor(int pisoLimite) {
        this.pisoLimite = pisoLimite;
    }

    public int getCont() {
        return cont;
    }

    public synchronized void entrar(int numPiso){
        try {
                while (numP != numPiso) wait();
                cont++;
                notifyAll();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void notificar(){
        notifyAll();
    }

    public synchronized void salir(int numPiso) {
        try {
                while (numP != numPiso) wait();
                cont--;
                notifyAll();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        notifyAll();
    }
}