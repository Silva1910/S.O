package SOExerc4_0109.controller;

public class controller extends Thread {

	private int maximo;

	public controller(int maximo) {
		this.maximo = maximo;
	}

	@Override
	public void run() {
		double fim = maximo;
	    int id = (int) getId();

	    while (fim > 0) {
	        double sapo = Math.random() * 100;
	        
	        if (sapo > fim) {
	            sapo = fim;  // Garante que o sapo não salte mais do que o que resta para a linha de chegada
	        }
	       
	        fim -= sapo;

	        System.out.printf("# %d sapo deu um salto de %.2f metros, faltam %.2f para ganhar\n", id, sapo, fim);
	    }

	    System.out.println("# " + id + " sapo chegou a linha de chegada!");

		
	}

}
