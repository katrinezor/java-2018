/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kathryn
 */
public class ServerView implements IServerView {
    Socket cs;
    
    ObjectInputStream ois;
    ObjectOutputStream oos;
    
    public ServerView(Socket _cs) {
        try {
            cs = _cs;
            ois = new ObjectInputStream(cs.getInputStream());
            oos = new ObjectOutputStream(cs.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
