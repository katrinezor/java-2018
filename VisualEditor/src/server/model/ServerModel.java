/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.util.ArrayList;
import server.presenter.IServerPresenter;

/**
 *
 * @author Kathryn
 */
public class ServerModel implements IServerModel {

    ArrayList<IServerPresenter> list_presenter = new ArrayList<>();
    
    void refresh()
    {
        for (IServerPresenter presenter : list_presenter) {
            presenter.update();
        }
    }
    
    @Override
    public void addPresenter(IServerPresenter p) {
        list_presenter.add(p);
        refresh();
    }

    @Override
    public void removePresenter(IServerPresenter p) {
        list_presenter.remove(p);
    }
    
}
