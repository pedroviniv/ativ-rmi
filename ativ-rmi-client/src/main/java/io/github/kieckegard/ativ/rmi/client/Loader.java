/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.ativ.rmi.client;

import io.github.kieckegard.ativ.rmi.shared.Calculator;
import io.github.kieckegard.ativ.rmi.shared.NamingService;
import java.rmi.NotBoundException;
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
    
    public static void main(String[] args) throws RemoteException, NotBoundException {

        String host = "rmi-registry";
        int port = 10999;
        
        LOG.log(Level.INFO, "Getting registry instance from {0}:{1}",
                new Object[]{host, port});
        
        Registry registry = LocateRegistry.getRegistry(host, port);
        
        LOG.log(Level.INFO, "Registry instance was successfully obtained!");
        
        LOG.log(Level.INFO, "Looking up the NAMING_SERVICE!");
        
        NamingService namingService = (NamingService) registry
                .lookup("NAMING_SERVICE");
        
        LOG.log(Level.INFO, "Looking up a CALCULATOR instance!");
        
        Calculator calculator = (Calculator) namingService.find("CALCULATOR");
        
        LOG.log(Level.INFO, "CALCULATOR lookup has been successfully done!");
        
        double a = -10.2d, b = 23.5d;
        
        double sumResult = calculator.sum(a, b);
        
        LOG.log(Level.INFO, "calculator.sum({0},{1}) = {2}",
                new Object[]{a,b,sumResult});
    }
}
