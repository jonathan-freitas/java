package Somatorio;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Jonathan Freitas on 06/03/2017.
 */

public class Produtor extends Thread{

    //Mantendo as referencias das variaveis
    ConcurrentLinkedQueue<Integer> list = null;
    Finish finish = null;

    //Metodo Construtor
    public Produtor(ConcurrentLinkedQueue list, Finish finish) {

            this.list = list;
            this.finish = finish;
    }

    public void run() {

        //Adicionando valores na fila
        for (int i = 1; i <= 10001; i++) {
            list.add(i);
        }

        //A variavel finish ira dar o start para as threads
        finish.setFinish(true);
        System.out.println("Produtor terminou.");
    }
}