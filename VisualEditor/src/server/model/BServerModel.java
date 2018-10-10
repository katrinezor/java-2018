/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

/**
 *
 * @author Kathryn
 */
public class BServerModel {
    static IServerModel m = new ServerModel();
    
    public static IServerModel model() {
        return m;
    }
}
