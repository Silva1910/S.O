package SOExerc5_0109.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class controller extends Thread {

	public controller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		try {
		    String command = "ping -4 -c 10 www.uol.com.br"; // Comando para Unix
		    Process process = Runtime.getRuntime().exec(command);

		    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		    String line;
		    StringBuilder output = new StringBuilder();
		    String averageTime = null;
		    boolean collectingOutput = true;

		    while ((line = reader.readLine()) != null) {
		        if (collectingOutput) {
		            output.append(line).append( "\n" + " server uol " + "    "); // Armazenar a saída em um StringBuilder

		            if (line.contains("time=")) {
		                int startIndex = line.indexOf("time=") + 5;
		                int endIndex = line.indexOf("ms", startIndex);
		                if (endIndex != -1) {
		                    averageTime = line.substring(startIndex, endIndex).trim();
		                }
		            }

		            if (line.contains("ping statistics")) {
		                // A linha "ping statistics" indica o final das estatísticas; pare de coletar após isso.
		                collectingOutput = false;
		            }
		        }
		    }

		    reader.close();

		    // Verifique se a última linha contém "ping statistics" e remova-a do StringBuilder de output.
		    if (output.toString().endsWith("ping statistics ---\n")) {
		        int lastIndex = output.lastIndexOf("ping statistics ---\n");
		        output.delete(lastIndex, output.length());
		    }

		    System.out.println(output.toString()); // Exibir todas as iterações com o servidor

		    if (averageTime != null) {
		        System.out.println("Tempo médio de ping do servidor uol: " + averageTime + " ms");
		    } else {
		        System.out.println("Não foi possível obter o tempo médio de ping.");
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
		try {
		    String command = "ping -4 -c 10 www.google.com.br"; // Comando para Unix
		    Process process = Runtime.getRuntime().exec(command);

		    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		    String line;
		    StringBuilder output = new StringBuilder();
		    String averageTime = null;
		    boolean collectingOutput = true;

		    while ((line = reader.readLine()) != null) {
		        if (collectingOutput) {
		            output.append(line).append("\n" + " server google" + "    " ); // Armazenar a saída em um StringBuilder

		            if (line.contains("time=")) {
		                int startIndex = line.indexOf("time=") + 5;
		                int endIndex = line.indexOf("ms", startIndex);
		                if (endIndex != -1) {
		                    averageTime = line.substring(startIndex, endIndex).trim();
		                }
		            }

		            if (line.contains("ping statistics")) {
		                // A linha "ping statistics" indica o final das estatísticas; pare de coletar após isso.
		                collectingOutput = false;
		            }
		        }
		    }

		    reader.close();

		    // Verifique se a última linha contém "ping statistics" e remova-a do StringBuilder de output.
		    if (output.toString().endsWith("ping statistics ---\n")) {
		        int lastIndex = output.lastIndexOf("ping statistics ---\n");
		        output.delete(lastIndex, output.length());
		    }

		    System.out.println(output.toString()); // Exibir todas as iterações com o servidor

		    if (averageTime != null) {
		        System.out.println("Tempo médio de ping do servidor google: " + averageTime + " ms");
		    } else {
		        System.out.println("Não foi possível obter o tempo médio de ping.");
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
		try {
		    String command = "ping -4 -c 10 www.terra.com.br"; // Comando para Unix
		    Process process = Runtime.getRuntime().exec(command);

		    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		    String line;
		    StringBuilder output = new StringBuilder();
		    String averageTime = null;
		    boolean collectingOutput = true;

		    while ((line = reader.readLine()) != null) {
		        if (collectingOutput) {
		            output.append(line).append("\n" + " server terra" + "    " ); // Armazenar a saída em um StringBuilder

		            if (line.contains("time=")) {
		                int startIndex = line.indexOf("time=") + 5;
		                int endIndex = line.indexOf("ms", startIndex);
		                if (endIndex != -1) {
		                    averageTime = line.substring(startIndex, endIndex).trim();
		                }
		            }

		            if (line.contains("ping statistics")) {
		                // A linha "ping statistics" indica o final das estatísticas; pare de coletar após isso.
		                collectingOutput = false;
		            }
		        }
		    }

		    reader.close();

		    // Verifique se a última linha contém "ping statistics" e remova-a do StringBuilder de output.
		    if (output.toString().endsWith("ping statistics ---\n")) {
		        int lastIndex = output.lastIndexOf("ping statistics ---\n");
		        output.delete(lastIndex, output.length());
		    }

		    System.out.println(output.toString()); // Exibir todas as iterações com o servidor

		    if (averageTime != null) {
		        System.out.println("Tempo médio de ping do servidor terra: " + averageTime + " ms");
		    } else {
		        System.out.println("Não foi possível obter o tempo médio de ping.");
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
