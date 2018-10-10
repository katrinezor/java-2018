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
public class BServerPresenter {
    public static IServerPresenter build(IServerView _view, IServerModel _model) {
        return new ServerPresenter(_view, _model);
    }
}
