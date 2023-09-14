package SOExerc4_0109.view;

import SOExerc4_0109.controller.controller;

public class main {

	public static void main(String[] args) {
		
		int maximo=100;
		
		for (int i = 0; i < 5; i++) {
			controller controller = new controller(maximo);
			controller.start();
		}
		

	}

}
