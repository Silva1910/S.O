package Aula3.Exercicio3.controller;

import java.util.concurrent.Semaphore;

public class ThreadTransacao extends Thread {

    private int cdgConta;
    private int[] saldos; // Vetor de saldos compartilhados
    private static int saldo = 20; 
    private int deposito;
    private int saque;
    private int numTransacao;

    private Semaphore semaforoDeposito;
    private Semaphore semaforoSaque;

    public ThreadTransacao(int numTransacao, Semaphore semaforoDeposito, Semaphore semaforoSaque, int cdgConta, int[] saldos) {
        this.numTransacao = numTransacao;	
    	this.cdgConta = cdgConta;
        this.semaforoDeposito = semaforoDeposito;
        this.semaforoSaque = semaforoSaque;
        this.saldos = saldos; // Inicialize o vetor de saldos
    }
	public void run() {
        try {
            if (Math.random() < 0.5) {
                semaforoDeposito.acquire();
                realizarDeposito();
                semaforoDeposito.release();
            } else {
                semaforoSaque.acquire();
                realizarSaque();
                semaforoSaque.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    private void realizarDeposito() {
        deposito = (int) (Math.random() * 501);
        saldos[cdgConta] += deposito; // Atualize o saldo da conta correta no vetor
        System.out.println("o codigo da conta e ==> "+ cdgConta + " esta foi a transacao de numero  " + numTransacao + "  Deposito no valor de " + deposito + " foi feito com sucesso. Saldo total e: " + saldos[cdgConta]);
    }

    private void realizarSaque() {
        saque = (int) (Math.random() * 501);

        if (saque > saldos[cdgConta]) {
            System.out.println("O seu saldo e insuficiente, o valor que possui na sua conta e " + saldos[cdgConta] + " nao corresponde ao valor que voce quer sacar no valor de " + saque);
        } else {
            saldos[cdgConta] -= saque; // Atualize o saldo da conta correta no vetor
            System.out.println("o codigo da conta e ==> "+ cdgConta + " esta foi a transacao de numero " + numTransacao + " Saque no valor de " + saque + " foi feito com sucesso. Saldo restante: " + saldos[cdgConta]);
        }
    }
}