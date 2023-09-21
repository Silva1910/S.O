package Aula3.Exercicio4.controller;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread {

	private Semaphore semaforoTotal;
	private Semaphore semaforoEscuderia;
	private int carro;
	private int escuderia;
	public static double[][][] matriz = new double[14][1][3]; // Cria uma matriz para 14 carros, 1 elemento por carro, 3 valores por elemento

	public ThreadCar(int carro, Semaphore semaforoTotal, Semaphore semaforoEscuderia, int escuderia) {
		this.carro = carro;
		this.semaforoTotal = semaforoTotal;
		this.semaforoEscuderia = semaforoEscuderia;
		this.escuderia = escuderia;

	}

	public void run() {
		try {
			semaforoEscuderia.acquire(); // Carro aguarda permissão para entrar na pista
			semaforoTotal.acquire(); // Carro aguarda permissão para entrar na pista global
			Pista();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoTotal.release(); // Carro sai da pista global
			semaforoEscuderia.release(); // Carro sai da pista da escuderia
		}
	}

	private void Pista() {
		DecimalFormat decimalFormat = new DecimalFormat("0.000000"); // Formato para exibir 6 casas decimais

		double voltaMaisRapida = Double.MAX_VALUE;

		for (int volta = 1; volta <= 3; volta++) {
			int distanciaVolta = 0;

			double tempoInicial = System.nanoTime();

			while (distanciaVolta < 200) {
				int distanciaPercorrida = (int) (Math.random() * 51);
				distanciaVolta += distanciaPercorrida;
			}

			double tempoFinal = System.nanoTime();
			double tempoVolta = (tempoFinal - tempoInicial) / Math.pow(10, 9);

			System.out.println("Volta " + volta + ": Tempo = " + decimalFormat.format(tempoVolta)
					+ " segundos do carro " + carro + " da Escuderia " + escuderia);

			if (tempoVolta < voltaMaisRapida) {
				voltaMaisRapida = tempoVolta;

			}
		}
		System.out.println("Carro " + carro + " da Escuderia " + escuderia + " saindo da pista."
				+ " Seu tempo mais rapido foi " + decimalFormat.format(voltaMaisRapida) + " segundos");
		matriz[carro - 1][0][0] = carro;
		matriz[carro - 1][0][1] = escuderia;
		matriz[carro - 1][0][2] = voltaMaisRapida;
	        
	}
	 public static void ordenarMatrizPorTempo(double[][][] matriz) {
	        Arrays.sort(matriz, (a, b) -> Double.compare(a[0][2], b[0][2]));
	    }

}
