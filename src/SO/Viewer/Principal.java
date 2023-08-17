package SO.Viewer;

import SO.Controller.*;

public class principal {
	public static void main(String[] args) {
		controller op = new controller();

		int[] vetor1 = new int[1000];
		int[] vetor2 = new int[10000];
		int[] vetor3 = new int[100000];

		for (int i = 0; i < 1000; i++) {
			vetor1[i] = 0;
		}

		for (int i = 0; i < 10000; i++) {
			vetor2[i] = 0;
		}

		for (int i = 0; i < 100000; i++) {
			vetor3[i] = 0;
		}

		op.vt1(vetor1);
		op.vt2(vetor2);
		op.vt3(vetor3);

	}
}
