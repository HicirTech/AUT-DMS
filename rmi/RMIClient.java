/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIexample;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Zeting Luo ID 16938158
 */
public class RMIClient {
    
    public static void main(String [] args){
        try{
            System.out.println("[Assignment 1]");
            System.out.println("[Laboratory 2, Exercise 2. - client]");
            System.out.println("Registry called");
            //call registry
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("Registry is created...");
            GuessNumberGame remoteProxy = (GuessNumberGame)registry.lookup("GuessNumber");     
            System.out.println("RMI project is " + remoteProxy.getGuessing());
            //user input for set up the random in server
            Scanner scan = new Scanner(System.in);
            System.out.println("Input a max number for random, this number will be pass to remote server");
            String message = scan.nextLine();
            remoteProxy.setRange(message);
            //begin user input guest 
            boolean userCorrect = false;
            do{
                System.out.print("Input a number: ");
                remoteProxy.setNumber(scan.nextLine());
                String response = remoteProxy.getGuessing();
                System.out.println(response);

                //if user get it right, stop the game
                if(response.equals("Correct guess!"))
                    userCorrect=true;
            }while(!userCorrect);
        }catch (RemoteException e){
            System.err.println("Unable to use registry: " + e);
        }catch (NotBoundException e){
            System.err.println("Name greeting not currently bound: " + e);
        }catch(ClassCastException e){
            System.err.println("Class Cast Exception: " + e);
        }
    }
}
