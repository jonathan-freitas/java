package Somatorio;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Jonathan Freitas on 06/03/2017.
 */

public class Main {

    ConcurrentLinkedQueue<Integer> list = null;
    Finish finish = null;
    Soma soma = null;

    //Metodo Construtor
    public Main(ConcurrentLinkedQueue list, Soma soma, Finish finish) {

            this.list = list;
            this.soma = soma;
            this.finish = finish;
    }

    //Instaciando as classes
    public static void main(String[] args) {

        Finish finish = new Finish();
        ConcurrentLinkedQueue<Integer> list = new ConcurrentLinkedQueue();
        Soma soma = new Soma();

        Produtor obj = new Produtor(list, finish);
        obj.start();

        Consumidor c1 = new Consumidor(list, soma, finish);
        c1.start();

        Consumidor c2 = new Consumidor(list, soma, finish);
        c2.start();

        //Aguardando a Thread "Produto" terminar de ser executada
        try {
            obj.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Aguardando a Thread "C2" terminar de ser executada
        try {
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Aguardando a Thread "C1" terminar de ser executada
        try {
            c1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A soma total é: " + soma.getSoma());
    }
}