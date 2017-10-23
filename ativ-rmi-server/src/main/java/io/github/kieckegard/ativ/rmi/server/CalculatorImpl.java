/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.ativ.rmi.server;

import io.github.kieckegard.ativ.rmi.shared.Calculator;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author kieckegard
 */
public class CalculatorImpl extends UnicastRemoteObject 
        implements Calculator, Serializable {

    public CalculatorImpl() throws RemoteException {
    }
    
    @Override
    public double sum(double a, double b) throws RemoteException {
        return a+b;
    }
    
}
