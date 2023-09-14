package SOExerc3_0109.view;

import SOExerc3_0109.controller.controller;

public class main {

	public static void main(String[] args) {

		int num1 = 2;
		int num2 = 3;
		int[] vetor = new int[1000];

		for (int i = 0; i < 3; i++) {

			vetor[i] = (int) (Math.random() * 101);

		}

		for (int i = 0; i < 2; i++) {
			controller controller = new controller(vetor, num1, num2);
			controller.start();
		}

	}

}
