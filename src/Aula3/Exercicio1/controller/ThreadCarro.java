package Aula3.Exercicio1.controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private static int posSaida = 0;
	public String lado = "";

	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			carroSaida();
			semaforo.release(); // Libere o semáforo após a saída.
		}
	}

	private void carroSaida() {
		posSaida++;
		System.out.println("#" + idCarro + " foi o " + posSaida + " e saiu pelo lado " + lado);

	}

	private void cruzamento() {

		if (idCarro == 0) {
			lado = "norte";
		} else if (idCarro == 1) {
			lado = "sul";
		} else if (idCarro == 2) {
			lado = "leste";
		} else if (idCarro == 3) {
			lado = "oeste";
		}

	}
}
