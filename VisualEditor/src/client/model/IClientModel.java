/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import client.view.IClientObserver;

/**
 *
 * @author Kathryn
 */
public interface IClientModel {
    void addObserver(IClientObserver observer);
    void init(); // Подключиться к серверу
}
