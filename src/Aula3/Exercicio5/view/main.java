package Aula3.Exercicio5.view;

import java.util.concurrent.Semaphore;
import Aula3.Exercicio5.controller.ThreadServer;

public class main {

    public static void main(String[] args) {
        int permissao = 21;
        Semaphore semaforo = new Semaphore(permissao);
        Semaphore semaforoBD = new Semaphore(1); // Semáforo para controlar o acesso ao banco de dados

        for (int idThread = 1; idThread <= 21; idThread++) {
            ThreadServer tServidor = new ThreadServer(idThread, semaforo, semaforoBD);
            tServidor.start();
        }
    }
}
