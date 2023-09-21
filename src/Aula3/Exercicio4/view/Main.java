package Aula3.Exercicio4.view;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

import Aula3.Exercicio4.controller.ThreadCar;

public class Main {

    public static void main(String[] args) {
        int numEscuderias = 7;
        int permissaoPorEscuderia = 2; // Agora duas duplas de cada escuderia na pista
        int permissaoTotal = 5; // Máximo de 5 carros na pista simultaneamente
        Semaphore semaforoTotal = new Semaphore(permissaoTotal);
        Semaphore[] semaforosPorEscuderia = new Semaphore[numEscuderias];
        DecimalFormat decimalFormat = new DecimalFormat("0.000000"); // Formato para exibir 6 casas decimais

        // Inicialize os semáforos para cada escuderia
        for (int i = 0; i < numEscuderias; i++) {
            semaforosPorEscuderia[i] = new Semaphore(permissaoPorEscuderia);
        }

        // Rastreie quantos carros de cada escuderia já foram iniciados
        int[] carrosIniciadosPorEscuderia = new int[numEscuderias];

        // Crie e inicie as threads dos carros
        ThreadCar[] threadsCarros = new ThreadCar[14];

        for (int carro = 0; carro < 14; carro++) {
            int escuderia = carro % numEscuderias; // Determina a escuderia deste carro

            // Verifique se já foram iniciados dois carros desta escuderia
            if (carrosIniciadosPorEscuderia[escuderia] < 2) {
                threadsCarros[carro] = new ThreadCar(carro + 1, semaforoTotal, semaforosPorEscuderia[escuderia],
                        escuderia);
                threadsCarros[carro].start();
                carrosIniciadosPorEscuderia[escuderia]++;
            }
        }

        // Aguarde todas as threads dos carros terminarem
        try {
            for (ThreadCar threadCar : threadsCarros) {
                if (threadCar != null) {
                    threadCar.join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadCar.ordenarMatrizPorTempo(ThreadCar.matriz);
        int posicao = 1; // Variável para rastrear a posição
        for (double[][] carroInfo : ThreadCar.matriz) {
            System.out.println("_________________________________________________________\n" +
            		"Posicao: " + posicao + ", Carro: " + (int) carroInfo[0][0] +
                    ", Escuderia: " + (int) carroInfo[0][1] +
                    ", Tempo Mais Rapido: " + decimalFormat.format( carroInfo[0][2]));
            posicao++;
        }
    }
}
