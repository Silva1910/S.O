package SOExerc0109.view;

import SOExerc0109.controller.*;


public class Principal {

	public static void main(String[] args) {
		for (int i = 0; i<5; i++) {
			 ThreadId theradId = new ThreadId (i); 
			 theradId.start();
		}

	}

}
