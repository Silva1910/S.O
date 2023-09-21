package Aula3.Exercicio5.controller;

import java.util.concurrent.Semaphore;

public class ThreadServer extends Thread {

    private int idThread;
    private Semaphore semaforo;
    private Semaphore semaforoBD;

    public ThreadServer(int idThread, Semaphore semaforo, Semaphore semaforoBD) {
        this.semaforo = semaforo;
        this.semaforoBD = semaforoBD;
        this.idThread = idThread;
    }

    public void run() {
        try {
            semaforo.acquire();
            realizarCalculos();
            realizarTransacoes();
            semaforo.release();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void realizarCalculos() {
        int resto = idThread % 3;
        long tempoCalculos;

        if (resto == 1) {
            tempoCalculos = (long) (Math.random() * 800 + 200);
        } else if (resto == 2) {
            tempoCalculos = (long) (Math.random() * 1000 + 500);
        } else {
            tempoCalculos = (long) (Math.random() * 1000 + 1000);
        }

        System.out.println(idThread + " - Iniciando calculos por " + (tempoCalculos / 1000.0) + " segundos");
        try {
            Thread.sleep(tempoCalculos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(idThread + " - Concluidos calculos");
    }

    private void realizarTransacoes() {
        int resto = idThread % 3;
        long tempoTransacaoBD;

        if (resto == 1) {
            tempoTransacaoBD = 1000;
        } else if (resto == 2) {
            tempoTransacaoBD = 1500;
        } else {
            tempoTransacaoBD = 1500;
        }

        System.out.println(idThread + " - Iniciando transacao de BD por " + (tempoTransacaoBD / 1000.0) + " segundos");
        try {
            semaforoBD.acquire(); // Apenas uma thread por vez pode acessar o banco de dados
            Thread.sleep(tempoTransacaoBD);
            System.out.println(idThread + " - Concluida transacao de BD");
            semaforoBD.release(); // Libera o acesso ao banco de dados
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
