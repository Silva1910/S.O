package SOExerc3_0109.controller;

public class controller extends Thread {
	private int[] vetor;
	private int decisor;
	private int decisor2;

	public controller(int vetor[], int n, int n2) {
		this.vetor = vetor;
		this.decisor = n;
		this.decisor2 = n2;
	}

	@Override
	public void run() {
		int id = (int) getId();

		if (decisor % 2 == 0) {

			double tempoInicial = System.nanoTime();
			for (int i = 0; i < vetor.length; i++) {
				double tempoFinal = System.nanoTime();
				double tempoTotal = (tempoFinal - tempoInicial) / Math.pow(10, 9);
				System.out.println("# ID Thread" + "==> " + id + "Tempo total do numero  divisivel por 2 : "
						+ String.format("%.7f", tempoTotal) + "s");

			}
		} else if (decisor2 % 2 == 0) {
			double tempoInicial = System.nanoTime();
			for (int i : vetor) {
				double tempoFinal = System.nanoTime();
				double tempoTotal = (tempoFinal - tempoInicial) / Math.pow(10, 9);
				System.out.println("# ID Thread" + "==> " + id + "Tempo total do numero não divisivel por 2 : "
						+ String.format("%.7f", tempoTotal) + "s");

			}
		} else {
			System.out.println("numero invalido");
		}
	}
}
