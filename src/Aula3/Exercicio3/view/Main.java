package Aula3.Exercicio3.view;

import java.util.concurrent.Semaphore;

import Aula3.Exercicio3.controller.ThreadTransacao;

public class Main {

    public static void main(String[] args) {
        int permissao = 1;
        int numContas = 10; // Defina o número de contas que deseja usar
        int[] saldos = new int[numContas]; // Vetor para armazenar os saldos
        Semaphore[] semaforos = new Semaphore[numContas]; // Vetor de semáforos para cada conta

        // Inicialize os saldos iniciais para cada conta
        for (int i = 0; i < numContas; i++) {
            saldos[i] = 1000; // Por exemplo, saldo inicial de 1000 para todas as contas
            semaforos[i] = new Semaphore(permissao);
        }

        // Crie threads de transação para cada conta
        for (int transacao = 1; transacao <= 20; transacao++) {
            int cdgConta = (int) (Math.random() * numContas);
            Thread tTransacao = new ThreadTransacao(transacao, semaforos[cdgConta], semaforos[cdgConta], cdgConta, saldos);
            tTransacao.start();
        }
    }
}
