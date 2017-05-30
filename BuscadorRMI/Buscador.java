package BuscadorRMI;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jonathan Freitas on 15/05/2017.
 */

public class Buscador extends UnicastRemoteObject implements IBuscador {

    private IBuscador proximo = null;

    Buscador() throws RemoteException {
        super();
    }

    //Injeção de dependencia
    public void setProximo(IBuscador proximo){
        this.proximo = proximo;
    }

    //Metodo responsavel pela busca.
    public File Buscar(String termo) throws RemoteException {

        BufferedReader br = null;

        //Especificando o diretório de busca.
        String dir = "C:\\Buscador";
        File diretorio = new File(dir);
        String[] nomesArquivos = diretorio.list(); //Listando os nomes dos arquivos que estão no diretório em um Array.

        //Percorrendo o Array
        for (int i = 0; i < nomesArquivos.length; i++){

            String aux = nomesArquivos[i];

            //Realizando a busca
            try {
                br = new BufferedReader(new FileReader(aux));
                for (String linha = br.readLine(); linha != null; linha = br.readLine()) {

                    //Se a atual linha contém o termo de busca..
                    if (linha.contains(termo)) {

                        //Fazendo uma copia do arquivo onde o termo foi encontrado
                        File arquivoResultado = new File(aux);

                        //Retornando o arquivo onde o termo foi encontrado
                        return arquivoResultado;
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (br != null) br.close();
                } catch (IOException ex) {
                }
            }
        }

        return proximo.Buscar(termo);
    }
}

    //String de resultado.
//    String resultado = "";

    //Especificando o diretório de busca.
//    String dir = "C:\\Buscador";
//    File diretorio = new File(dir);
//    String[] nomesArquivos = diretorio.list(); //Listando os nomes dos arquivos que estão no diretório em um Array.

//        //Laço para percorrer o Array em busca do termo.
//        for(int i = 0; i < nomesArquivos.length; i++){
//            String aux = nomesArquivos[i];
//
//            if(aux.startsWith(termo)){
//                resultado = "O arquivo " + termo + "foi encontrado!";
//            } else {
//                resultado = "O arquivo " + termo + "não foi encontrado no repositório atual, " +
//                            "enviando para outro objeto..";
//            }
//        }
