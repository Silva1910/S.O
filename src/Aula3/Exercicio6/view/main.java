package Aula3.Exercicio6.view;

import java.util.concurrent.Semaphore;

import Aula3.Exercicio6.controller.ThreadPrato;

public class main {

	public static void main(String[] args) {

		int permissao = 5;
		int permissaoEntrega = 1;
		Semaphore semaforo = new Semaphore(permissao);
		Semaphore semaforoSaida = new Semaphore(permissaoEntrega);
		for (int idPratos = 0; idPratos < 5; idPratos++) {
			Thread tPrato = new ThreadPrato(idPratos, semaforo, semaforoSaida);
			tPrato.start();

		}

	}

}
