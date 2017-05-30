package BuscadorRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Jonathan Freitas on 15/05/2017.
 */

public class ProcessoObjects {

    private ProcessoObjects() throws Exception {
        comRMI();
    }

    private void comRMI() throws Exception {

        //Procurando o repositorio.
        Registry rmiRegistry = LocateRegistry.getRegistry("127.0.0.1",1234);
        System.out.println("Fazendo chamada.");

        //Instanciando os objetos.
        IBuscador objetoJohn = new Buscador();
        IBuscador objetoPedro = (IBuscador) rmiRegistry.lookup("obPedro");

        //Setando o proximo objeto de busca.
        ((Buscador)objetoJohn).setProximo(objetoPedro);

        //Cadastrando objeto no repositório.
        //reg.rebind -> vai fazer a ligação no registro.
        rmiRegistry.rebind("obJohn", objetoJohn);
        System.out.println("Objeto cadastrado.");
    }

    public static void main(String[] args) throws Exception {
        new ProcessoObjects();
    }
}
