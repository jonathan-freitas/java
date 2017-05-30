package BuscadorRMI;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by Jonathan Freitas on 15/05/2017.
 */

public class ProcessoBuscar {

    //Inicializando a variavel que irá receber o termo de busca
    private static String termo = "";


    private ProcessoBuscar() throws Exception {
        buscaRMI();
    }

    private void buscaRMI() throws Exception {

        //Procurando repositório.
        Registry rmiRegistry = LocateRegistry.getRegistry("127.0.0.1",1234);
        System.out.println("Fazendo chamada.");

        //Procurando pelo objeto.
        IBuscador ib = (IBuscador) rmiRegistry.lookup("obJohn");

        //Executando o método do objeto.
        File arquivoResultado = ib.Buscar(termo);

        //Caso o arquivo retornado não seje null e ele possa ser lido, imprima sucesso na tela do cliente
        if(arquivoResultado != null && arquivoResultado.canRead()){
            Sucesso();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        //Recebendo o termo de busca do usuário.
        System.out.println("Insira o termo para a busca.");
        termo = scan.nextLine();
        new ProcessoBuscar();
    }

    //Sucesso na busca
    private void Sucesso(){
        System.out.println("O termo pesquisado foi encontrado!");
    }
}
