/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.presenter;

import server.model.IServerModel;
import server.view.IServerView;

/**
 *
 * @author Kathryn
 */
public class ServerPresenter implements IServerPresenter {
    IServerView server_view;
    IServerModel server_model;

    public ServerPresenter(IServerView _view, IServerModel _model) {
        server_view = _view;
        server_model = _model;
        
        start();
        server_model.addPresenter(this);
    }

    void start() {
        ServerPresenter presenter = this;
        
        new Thread() {
            @Override
            public void run() {
                
            }
        }.start();
    }
    
    @Override
    public void update() {
        
    }
}
