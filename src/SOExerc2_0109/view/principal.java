package SOExerc2_0109.view;
import SOExerc2_0109.*;
import SOExerc2_0109.controller.controller;


public class principal {
	public static void main(String[] args) {
		
		int[][] matriz = new int[3][5];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {

				 matriz[i][j] = (int) (Math.random() * 11);
			}
		}

		for (int i = 0; i < 3; i++) {
			controller controller = new controller(matriz);
	        controller.start();
		}
		
					
	
}
}
