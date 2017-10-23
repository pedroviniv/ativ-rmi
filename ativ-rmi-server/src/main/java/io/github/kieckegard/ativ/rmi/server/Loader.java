/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.ativ.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieckegard
 */
public class Loader {

    private static final Logger LOG = Logger.getLogger(Loader.class.getName());
    
    public static void main(String[] args) throws RemoteException, 
            AlreadyBoundException {
        
        String host = "localhost";
        int port = 10999;
        
        LOG.log(Level.INFO, "Getting Registry on {0}:{1}... ", new Object[]{host,port});
        
        Registry registry = LocateRegistry.getRegistry(host, port);
        
        LOG.log(Level.INFO, "Registry reference successfully obtained!");
        
        LOG.log(Level.INFO, "BINDING CalculatorImpl into Registry... ");
        
        registry.bind("CALCULATOR", new CalculatorImpl());
        
        LOG.log(Level.INFO, "CalculatorImpl was successfully bound and"
                + " can be accessed by \"CALCULATOR\" name!");
        
        
    }
}
