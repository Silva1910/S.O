package SOExerc2_0109.controller;

public class controller extends Thread {

	private int[][] matriz;

     
	public  controller(int[][] matriz) {
        this.matriz = matriz;
       
    }

    @Override
    public void run() {
        int calc1 = 0;
        int calc2 = 0;
        int calc3 = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    calc1 += matriz[i][j];
                } else if (i == 1) {
                    calc2 += matriz[i][j];
                } else if (i == 2) {
                    calc3 += matriz[i][j];
                }
            }
        }
        int id =(int) getId();
        System.out.println("# ID Thread"+ "==> "   +    id + "   " + "Linha 1: " + calc1);
        System.out.println("# ID Thread"+ "==> "   +    id + "   " + "Linha 2: " + calc2);
        System.out.println("# ID Thread"+ "==> "   +    id + "   " + "Linha 3: " + calc3);

		
}
    }
