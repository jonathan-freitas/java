package ConexaoDeObjetos;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by Jonathan Freitas on 31/03/2017.
 */

public class ServerSocket {

    public static void main(String[] args) {

        Pessoa joao = null;

        try {

            //Criando Servidor
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(2001);
            System.out.println("Servidor aguardando...");
            Socket server = serverSocket.accept(); //Chamada Bloqueante

            //Input para receber o objeto e Output para enviar de volta o objeto
            ObjectInputStream ServerInput = new ObjectInputStream(server.getInputStream());
            ObjectOutputStream ServerOutput = new ObjectOutputStream(server.getOutputStream());

            //Aguardando envio de mensagem
            boolean done = false;
            while(!done){

                //Lendo a mensagem
                byte messageType = ServerInput.readByte();
                joao = (Pessoa)ServerInput.readObject();

                switch (messageType)
                {
                    case 1: //Alterando e imprimindo a mensagem
                        System.out.println("Mensagem recebida com sucesso: " + joao.imprimirDados());

                        //aux = ano de nascimento recebido pelo objeto enviado
                        //anoAtual = recebe o ano atual
                        //idade = calcula e guarda o valor da idade do objeto
                        int aux = joao.getDataNasc().getYear();
                        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

                        //Verificando a idade levando em conta os dias do ano atual e os do ano do objeto
                        if(joao.getDataNasc().getDayOfYear() > Calendar.getInstance().get(Calendar.DAY_OF_YEAR)){
                            int fator =     -1;
                            int idade = (anoAtual - aux + fator);

                            //Setando a idade calculada da pessoa
                            joao.setIdade(idade);

                        } else {
                            int idade = anoAtual - aux;

                            //Setando a idade calculada da pessoa
                            joao.setIdade(idade);
                        }

                        //Enviando mensagem
                        System.out.println("Mensagem alterada com sucesso: " + joao.imprimirDados());
                        ServerOutput.writeByte(1);
                        ServerOutput.writeObject(joao);

                        break;

                    default:
                        done = true;
                }
            }

            //Fechando conexões
            ServerInput.close();
            ServerOutput.close();
            server.close();
            serverSocket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
