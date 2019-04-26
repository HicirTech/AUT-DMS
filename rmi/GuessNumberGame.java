/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIexample;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Zeting Luo ID 16938158
 */
public interface GuessNumberGame extends Remote{
    public String getGuessing() throws RemoteException;
    public void setGuessing(String currentMessage) throws RemoteException;
    public void setNumber(String userInput) throws RemoteException;
    public void setRange(String randomTop) throws RemoteException;
}
