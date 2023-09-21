package Aula3.Exercicio1.view;

import java.util.concurrent.Semaphore;

import Aula3.Exercicio1.controller.ThreadCarro;

public class main {

	public static void main(String[] args) {
	int permissao = 1;
	Semaphore semaforo = new Semaphore(permissao); 
	for (int idCarro = 1; idCarro <=4; idCarro++) {
		Thread tCarro = new ThreadCarro(idCarro, semaforo);
		tCarro.start();
		
	}

	}

}
