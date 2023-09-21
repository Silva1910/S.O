package Aula3.Exercicio2.view;

import java.util.concurrent.Semaphore;

import Aula3.Exercicio2.controller.ThreadPessoa;

public class main {

	public static void main(String[] args) {

		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int pessoa = 1; pessoa <= 4; pessoa++) {
			Thread tPessoa = new ThreadPessoa(pessoa, semaforo);
			tPessoa.start();
		}
	}

}
