package SO.Controller;

public class Controller {
	public Controller() {
		super();
	}

	public void vt1(int[] vetor1) {
		{
			double temporInicial = System.nanoTime();
			for (int i = 0; i < 1000; i++) {
			
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - temporInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("o tempo total do vetor 1 e ==>" + String.format("%.7f", tempoTotal) + "s" );
		}
	}

	public void vt2(int[] vetor2) {
		{
			double temporInicial = System.nanoTime();
			for (int i = 0; i < 10000; i++) {
				
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - temporInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("o tempo total do vetor 2 e ==>" + String.format("%.7f", tempoTotal) + "s" );
		}

	}
	public void vt3(int [] vetor3 ) {
		{
			double temporInicial = System.nanoTime();
			for (int i = 0; i < 100000; i++) {
				
			
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - temporInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("o tempo total do vetor 3 e ==>" + String.format("%.7f", tempoTotal) + "s" );
		}

	}




}
