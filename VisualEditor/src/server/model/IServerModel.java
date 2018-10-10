/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import server.presenter.IServerPresenter;

/**
 *
 * @author Kathryn
 */
public interface IServerModel {
    void addPresenter(IServerPresenter p);
    void removePresenter(IServerPresenter p);
}
