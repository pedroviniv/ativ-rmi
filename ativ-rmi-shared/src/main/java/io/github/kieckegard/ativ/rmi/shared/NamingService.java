/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.ativ.rmi.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author kieckegard
 */
public interface NamingService extends Remote {
    
    void save(String name, Remote obj) throws RemoteException;
    Remote find(String name) throws RemoteException;
}
