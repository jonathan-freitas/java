package Somatorio;

/**
 * Created by Jonathan Freitas on 06/03/2017.
 */

public class Soma {

    private int soma;

    public int getSoma(){
        return soma;
    }

    public void setSoma(int x){
        this.soma = x;
    }

    //Método responsavel por realizar a somatoria
    public int somarTotal(int x){
        int aux;

        aux = getSoma();
        aux = aux + x;
        setSoma(aux);

        return aux;
    }
}
