package Aula3.Exercicio2.controller;

import java.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {

    private int pessoa;
    private Semaphore semaforo;
    private static int posSaida = 0;

    public ThreadPessoa(int pessoa, Semaphore semaforo) {
        this.pessoa = pessoa;
        this.semaforo = semaforo;
    }

    public void run() {
        corredor();
        try {
            semaforo.acquire();
            Porta();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
            saidaPorta();
        }
    }

    private void Porta() {
        System.out.println("#" + pessoa + " chegou a porta ");
        int tempo = (int) ((Math.random() * 2) + 1); // Tempo aleatório entre 1 e 2 segundos
        try {
            sleep(tempo * 1000); // Converter segundos em milissegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void saidaPorta() {
        posSaida++;
        System.out.println("#" + pessoa + " saiu pela porta, e foi  " + posSaida+ "   a sair");
    }

    public void corredor() {
        int distancia = 0;
        int fim = 200;
        while (fim > distancia) {
            distancia += (int) ((Math.random() * 5) + 2); // Distância aleatória entre 2 e 6 metros
            System.out.println("#" + pessoa + " percorreu " + distancia + " metros");
        }
    }
}
