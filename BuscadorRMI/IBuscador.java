package BuscadorRMI;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jonathan Freitas on 15/05/2017.
 */

//Interface
public interface IBuscador extends Remote {

    public void setProximo(IBuscador proximo) throws RemoteException;
    public File Buscar(String termo) throws RemoteException;

}
