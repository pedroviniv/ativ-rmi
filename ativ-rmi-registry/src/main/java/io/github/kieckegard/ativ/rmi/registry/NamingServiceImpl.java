/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.ativ.rmi.registry;

import io.github.kieckegard.ativ.rmi.shared.NamingService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieckegard
 */
public class NamingServiceImpl extends UnicastRemoteObject implements NamingService {

    private final Map<String, Remote> remoteObjects;
    private static final Logger LOG = Logger.getLogger(NamingServiceImpl.class.getName());
    
    public NamingServiceImpl() throws RemoteException {
        this.remoteObjects = new HashMap<>();
    }
    
    @Override
    public void save(String name, Remote obj) throws RemoteException {
        LOG.log(Level.INFO, "Saving a remote object {0}... It can be identified"
                + " by {1}", new Object[]{obj, name});
        this.remoteObjects.put(name, obj);
    }

    @Override
    public Remote find(String name) throws RemoteException {
        Remote remote = remoteObjects.get(name);
        LOG.log(Level.INFO, "A remote object named {0} has been found."
                + " Its null? {1}", new Object[]{name, remote == null});
        
        return remote;
    }
    
}
