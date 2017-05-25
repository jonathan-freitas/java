package CorridaSaposFodas;

public class Sapo extends Thread {
	
	int id;
	int posicao = 0;
	long pista;
	long dist = 0;
	
	public Sapo(int id, long pista) {
		this.id = id;
		this.pista = pista;
	}

	public void run() {
		
		while(dist <= pista){
			long salto = (long) 1; //(Math.random()*10);
			this.dist += salto;
		}
		
		System.out.println("Sapo " + this.id + " chegou.");
	}
}
