/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import client.view.IClientObserver;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kathryn
 */
public class ClientModel implements IClientModel {
    int port = 3124;
    InetAddress ip = null;

    Socket cs;
    ObjectInputStream ois;
    ObjectOutputStream oos;
        
    ArrayList<IClientObserver> list_observer = new ArrayList<>();

    void refresh()
    {
        for (IClientObserver observer : list_observer) {
            observer.refresh();
        }
    }
    
    @Override
    public void addObserver(IClientObserver observer) {
        list_observer.add(observer);
    }

    @Override
    public void init() {
        if(cs != null) return;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cs = new Socket(ip, port);
            System.out.append("Client start \n");
            ois = new ObjectInputStream(cs.getInputStream());
            oos = new ObjectOutputStream(cs.getOutputStream());
            
            new Thread() {
                @Override
                public void run() {
                    while(true)
                    {
                        //read something
                        refresh();
                    }
                }
            }.start();
        } catch (IOException ex) {
            Logger.getLogger(ClientModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.append("Client start \n");
    }
}
