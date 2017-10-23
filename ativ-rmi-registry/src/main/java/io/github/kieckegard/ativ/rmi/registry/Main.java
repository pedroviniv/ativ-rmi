/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.ativ.rmi.registry;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieckegard
 */
public class Main extends UnicastRemoteObject {
    
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public Main() throws RemoteException {
    }
    
    public static void main(String[] args) {
        
        try {
            Main main = new Main();
            main.startRegistry(10999);
        } catch (RemoteException | AlreadyBoundException ex) {
            LOG.log(Level.WARNING, "An problem occurred while starting Registry", ex);
        }
    }
    
    public void startRegistry(int port) throws RemoteException, 
            AlreadyBoundException {
        
        LOG.log(Level.INFO, "Creating Registry on port {0}", port);
        
        Registry registry = LocateRegistry.createRegistry(port);
        
        registry.bind("NAMING_SERVICE", new NamingServiceImpl());
        
        LOG.log(Level.INFO, "Registry successfully created!");
        
        LOG.log(Level.INFO, "Waiting for connections... ", port);
    }
}
