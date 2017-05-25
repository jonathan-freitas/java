package ConexaoDeObjetos;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Jonathan Freitas on 31/03/2017.
 */

public class ClientSocket {

    public static void main(String[] args){

        try{

            //Conectando com  o servidor
            Socket cliente = new Socket("localhost",2001);
            System.out.println("Conexão com o servidor estabalecida.");

            //Input e Output para receber o objeto de volta e enviar o objeto
            ObjectOutputStream ClientOutput = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream ClientInput = new ObjectInputStream(cliente.getInputStream());

            //Criando um novo objeto do tipo "Pessoa"
            //Nome: João
            //Data de Nascimento: 26 de Janeiro de 1995
            //Idade: 0
            Pessoa joao = new Pessoa("João", LocalDate.of(1995, Month.DECEMBER, 26), 0);

            //Certificando que o objeto está criado corretamente:
            System.out.println("Enviando os seguintes dados: " + joao.imprimirDados());

            //Enviando mensagem
            ClientOutput.writeByte(1);
            ClientOutput.writeObject(joao);

            //Aguardando envio do objeto de volta
            boolean done = false;
            while(!done){

                //Lendo o objeto retornado
                byte messageType = ClientInput.readByte();

                switch (messageType)
                {
                    case 1: //Recebendo os valores e imprimindo o resultado
                        joao = (Pessoa)ClientInput.readObject();
                        System.out.println("Mensagem recebida com sucesso: " + joao.imprimirDados());
                        break;

                    default:
                        done = true;
                }
            }

            //Fechando conexões
            ClientOutput.close();
            ClientInput.close();
            cliente.close();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
