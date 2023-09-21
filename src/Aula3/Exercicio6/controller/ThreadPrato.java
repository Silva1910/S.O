package Aula3.Exercicio6.controller;

import java.util.concurrent.Semaphore;

public class ThreadPrato extends Thread {
    private int IdPrato;
    private Semaphore semaforo;
    private Semaphore semaforoSaida;
    private String prato;
    private long tempoCozimento=0;

    public ThreadPrato(int IdPrato, Semaphore semaforo, Semaphore semaforoSaida) {
        this.IdPrato = IdPrato;
        this.semaforo = semaforo;
        this.semaforoSaida = semaforoSaida;
    }

    @Override
    public void run() {
        if (IdPrato % 2 == 0) {
            prato = "lasanha a bolonhesa";
        } else {
            prato = "sopa de cebola";
        }

        try {
            semaforo.acquire();
            cozimento();
            System.out.println("O prato de " + prato + " entrou em cozimento (ID: " + IdPrato + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforoSaida.release(); // Libere o semáforo de saída após a entrega.
            semaforo.release(); // Libere o semáforo após a saída.
        }
    }

    private void cozimento() {
        if (IdPrato % 2 == 0) {
            while (tempoCozimento < 600 || tempoCozimento > 1200) {
                System.out.println("Cozinhando " + prato + " (ID: " + IdPrato + ") ==> " + (tempoCozimento / 10) + "%");
                try {
                    Thread.sleep(100); // Aguardar 0,1 segundos (100 milissegundos)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tempoCozimento += 100;
            }
        } else {
            while (tempoCozimento < 500 || tempoCozimento > 800) {
                System.out.println("Cozinhando " + prato + " (ID: " + IdPrato + ") ==> " + (tempoCozimento / 10) + "%");
                try {
                    Thread.sleep(100); // Aguardar 0,1 segundos (100 milissegundos)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tempoCozimento += 100;
            }
        }
        System.out.println("O prato de " + prato + " (ID: " + IdPrato + ") está pronto!");
        entregarPrato();
    }

    private void entregarPrato() {
        try {
            Thread.sleep(500); // Simular o tempo de entrega de 0,5 segundos.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Prato de " + prato + " (ID: " + IdPrato + ") entregue.");
    }
}
