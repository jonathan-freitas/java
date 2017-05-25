package ConexaoDeStrings;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by Jonathan Freitas on 27/03/2017.
 */

public class ServerSocket {

    private static String msg_received;

    public static void main(String[] args) {

        try {

            //Criando Servidor
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(2001);
            System.out.println("Servidor aguardando...");
            Socket server = serverSocket.accept(); //Chamada Bloqueante

            //Input para receber a mensagem
            DataInputStream dIn = new DataInputStream(server.getInputStream());

            //Output para enviar de volta a mensagem
            DataOutputStream dOut = new DataOutputStream(server.getOutputStream());

            //Aguardando envio de mensagem
            boolean done = false;
            while(!done){

                //Lendo a mensagem
                byte messageType = dIn.readByte();

                switch (messageType)
                {
                    case 1: //Imprimindo a mensagem
                        String mensagemCA = dIn.readUTF().toUpperCase();
                        System.out.println("Mensagem recebida e alterada: " + mensagemCA + "\nEnviando de volta..");

                        //Enviando mensagem
                        dOut.writeByte(1);
                        dOut.writeUTF(mensagemCA);
                        dOut.flush();

                        break;
                    default:
                        done = true;
                }
            }

            //Fechando conexões
            dIn.close();
            server.close();
            serverSocket.close();


            //msg_received = dIn.readUTF();
            //System.out.println("Mensagem recebida: " + msg_received);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

