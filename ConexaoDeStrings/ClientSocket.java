package ConexaoDeStrings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Jonathan Freitas on 27/03/2017.
 */

public class ClientSocket {

    private static String msg = "ornintorrinco";

    public static void main(String[] args){

        try{

            //Conectando com  o servidor
            Socket cliente = new Socket("localhost",2001);
            System.out.println("Conexão com o servidor estabalecida.");

            //Input para receber a mensagem de volta
            DataInputStream dIn = new DataInputStream(cliente.getInputStream());

            //Output para enviar a mensagem
            DataOutputStream dOut = new DataOutputStream(cliente.getOutputStream());

            //Enviando mensagem
            dOut.writeByte(1);
            dOut.writeUTF(msg);
            dOut.flush();

            //Aguardando envio de mensagem de volta
            boolean done = false;
            while(!done){

                //Lendo a mensagem retornada
                byte messageType = dIn.readByte();

                switch (messageType)
                {
                    case 1: //Imprimindo a mensagem retornada
                        System.out.println("Mensagem recebida: " + dIn.readUTF());
                        break;
                    default:
                        done = true;
                }
            }

            //Fechando conexões
            dOut.close();
            cliente.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
