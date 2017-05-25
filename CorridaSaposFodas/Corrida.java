package CorridaSaposFodas;

public class Corrida {
	
	public Corrida() throws Exception {
		Sapo[] sapos = new Sapo[10];
				
		for(int i = 0; i < 10; i++){
			sapos[i] = new Sapo(i, 1000000);
		}
		
		for(int i = 0; i < 10; i++){
			sapos[i].start();
		}
		
		for(int i = 0; i < 10; i++){
			sapos[i].join();
		}
		
		System.out.println("FIM");
	}
	
	public static void main(String[] args) throws Exception{
		new Corrida();
	}

}
