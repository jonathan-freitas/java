package ConexaoDeObjetos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * Created by Jonathan Freitas on 31/03/2017.
 */

public class Pessoa implements Serializable {

    //Variaveis
    private String nome;
    private LocalDate dataNasc;//LocalDate.of(1995, Month.JANUARY, 26);
    private int idade;

    //Construtor
    Pessoa(String nomeC, LocalDate dataNascC, int idadeC){
        nome = nomeC;
        dataNasc = dataNascC;
        idade = idadeC;
    }

    //Get's e Set's
    public String getNome(){
        return nome;
    }
    public void setNome(String x){
        this.nome = x;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int x){
        this.idade = x;
    }

    public LocalDate getDataNasc(){
        return dataNasc;
    }
    public void setDataNasc(LocalDate x){
        this.dataNasc = x;
    }

    //Imprimir valores
    public String imprimirDados(){

        return "\n----------------------------" +
                "\nNome: " + nome +
                "\nData de Nascimento: " + dataNasc.getDayOfMonth() + "/" + dataNasc.getMonthValue() + "/" + dataNasc.getYear() +
                "\nIdade: " + idade +
                "\n---------------------------";
    }

}
