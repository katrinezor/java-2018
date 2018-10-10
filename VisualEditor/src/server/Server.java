/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.model.BServerModel;
import server.model.IServerModel;
import server.presenter.BServerPresenter;
import server.presenter.IServerPresenter;
import server.view.BServerView;
import server.view.IServerView;

/**
 *
 * @author Kathryn
 */
public class Server {
    int port = 3124;
    InetAddress ip = null;
    
    public void serverStart() {
        IServerModel model = BServerModel.model();
        
        ServerSocket ss;
        Socket cs;
        
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ss = new ServerSocket(port, 0, ip);
            System.out.println("Server start");
            while(true)
            {
                cs = ss.accept();
                System.out.println("Has connect");
                IServerView view = BServerView.build(cs);
                IServerPresenter presenter = BServerPresenter.build(view, model);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        new Server().serverStart();
    }
}
