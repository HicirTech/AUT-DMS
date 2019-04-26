/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIexample;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIServer implements GuessNumberGame{
    
    private String message;
    private int value;
    public RMIServer(String message){
        this.message = message;
        this.value = 0;
    }
    public static void main(String [] args){
        System.out.println("[Assignment 1]");
        System.out.println("[Laboratory 2, Exercise 2. - Server]");
        System.out.println("In the Main Method of RMIServer...");
        RMIServer remoteObject = new RMIServer("[Week 2 E2: Guess number]");
        System.out.println("RMIServer Object is created...");
        try{
            System.out.println("RMIServer: Creating the UnicasteRemoteObject...");
            GuessNumberGame stub = (GuessNumberGame) UnicastRemoteObject.exportObject(remoteObject, 0);
            System.out.println("RMIServer: Creating the Registry...");
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("RMIServer: Registring the Remote object with name GuessNumber...");
            registry.rebind("GuessNumber", stub);
            System.out.println("Remote Object is bound with RMI Registry...");
            try{
                String []bindings = Naming.list("localhost");
                for(String name : bindings){
                    System.out.println(name);
                }
            }catch(MalformedURLException e){
                System.err.println("Unable to see names: " + e);
            }
        }catch(RemoteException e){
            System.err.println("Unable to bind to registry." + e);
        }
    } 
    //code reuse from week1 E5
    public void guessResult(String userinputString, int value) throws RemoteException
    {
       String result;
        if (userinputString == "")
            result = "Enter a number";
        else
        {  try
           {  
              int userInput = Integer.parseInt(userinputString);
              if (userInput < value)
                 result = "Guess too low, try again";
              else if (userInput > value)
                 result = "Guess too high, try again";
              else
                 result = "Correct guess!";
           }
           catch (NumberFormatException e)
           {  
               result = "Input missmatch";
           }
        }
       this.setGuessing(result);
    }   
    public void initialRange(String randomTop)
    {
         this.value = new Random().nextInt(Integer.parseInt(randomTop)); 
         System.out.println("["+this.value+" IS THE ANSWER]");
    } 
    
    @Override
    public String getGuessing() throws RemoteException {
        System.out.println("[GET GUESSING IS CALLED IN SERVER]");
        return this.message;
    }

    @Override
    public void setGuessing(String currentMessage) throws RemoteException {
        System.out.println("[SET MESSAGE IN SERVER IS CALLED IN SERVER] CURRENT MESSAGE : "+message);
        this.message = currentMessage;
    }
    
    @Override
    public void setNumber(String userInput) throws RemoteException {
        guessResult(userInput, this.value);
        System.out.println("[SET INPUT NUMBER IS CALLED IN SERVER USER INPUT: "+userInput +"]");
    }

    @Override
    public void setRange(String randomTop) throws RemoteException {
        System.out.println("[USER INPUT "+randomTop+" AS THE RANDOM TOP NUMBER]");
        initialRange(randomTop);
    }
}
