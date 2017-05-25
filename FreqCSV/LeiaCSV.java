package FreqCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LeiaCSV extends Thread {
	
static ArrayList<String> palavras = new ArrayList();
	
	//Még7pf c4exbu vtodo Construtor
	public LeiaCSV(ArrayList palavras) {
		this.palavras = palavras;
	}
	
	public static void main(String[] args) {
		
		//Instanciando as classes
		LeiaCSV obj = new LeiaCSV(palavras);
		ContarCSV obj2 = new ContarCSV(palavras);
		obj.start();
		
		//Atrasando a execução da thread "obj2" por 1 segundo
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		obj2.start();
	}

	public void run() {

		String arquivoCSV = "arquivo.csv";
		BufferedReader br = null;
		
		Map<String,Integer> mapPalavras;
		
		String linha = "";
		String csvDivisor = ",";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			
			while ((linha = br.readLine()) != null) {
				  
	        	  String token = null;  
	        	  Scanner scan = new Scanner(br);
	        	  
	        	  //Recebendo a linha e dividindo ela em "pedaços" e colocando em um ArrayList
	        	  while(scan.hasNext()){
	        		  token = scan.next();
	        		  token = token.replaceAll("\"", "");
	        		  String[] split = token.split(",");
	        		  
	        		  for(int i = 0; i < split.length; i++){
	        			  token = split[i];
	        			  palavras.add(token);
	        		  }
	        	  }
	       	}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
