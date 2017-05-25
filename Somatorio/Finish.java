package Somatorio;

/**
 * Created by Jonathan Freitas on 07/03/2017.
 */

public class Finish {

    //Objeto reponsavel por guardar a variavel 'finish', que ira ditar quando as threads de soma iram fechar.
    private boolean finish = false;

    public boolean getFinish(){
        return finish;
    }

    public void setFinish(boolean x){
        this.finish = x;
    }
}
