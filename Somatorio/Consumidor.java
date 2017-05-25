package Somatorio;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Jonathan Freitas on 06/03/2017.
 */

public class Consumidor extends Thread {

    //Mantendo as referências das variáveis
    ConcurrentLinkedQueue<Integer> list = null;
    Finish finish = null;
    Soma soma = null;

    //Metodo Construtor
    public Consumidor(ConcurrentLinkedQueue list, Soma soma, Finish finish){

            this.list = list;
            this.soma = soma;
            this.finish = finish;
    }

    public void run(){
        int aux;

        //Syncronized garantindo que apenas 1 thread acesse a lista por vez
        synchronized (this.finish) {

            //Enquanto o finish for 'false' ou a list não for vazia..
            while (!finish.getFinish() || !list.isEmpty()) {
                if(list.isEmpty())
                    continue;
                aux = soma.somarTotal(list.poll());
                soma.setSoma(aux);
            }
        }

         System.out.println("Thread terminou.");

    }
}
