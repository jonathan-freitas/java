package FreqCSV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class ContarCSV extends Thread{

	ArrayList<String> palavras = new ArrayList();
	
	//M�todo Construtor
	public ContarCSV(ArrayList palavras) {
		this.palavras = palavras;
	}
	
	public void run() {
		
		//Criando o HashMap para receber a contagem das palavras
		Map<String,Integer> mapPalavras;
		mapPalavras = new HashMap<String,Integer>();
			
        String token = null;  
        
        //Removendo as palavras do ArrayList e adicionando em um HashMap, ao mesmo tempo fazendo a contagem da frequ�ncia
        for(int i = 0; i < palavras.size(); i++){
        	token = palavras.remove(0);
        	
        	if(!mapPalavras.containsKey(token)){
      		  mapPalavras.put(token, 1);
      	  }
      	  
      	  else {
      		  mapPalavras.put(token, mapPalavras.get(token) +1);
      	  }
        	
        }
      	
        //Imprimindo o resultado
        for(Entry<String, Integer>EN: mapPalavras.entrySet()){
			System.out.println("Entrada: " + EN.getKey() + "\tFrequ�ncia: " + EN.getValue());
		}
        
    }
}
	

