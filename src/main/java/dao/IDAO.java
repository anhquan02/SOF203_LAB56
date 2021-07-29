/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author Mypc
 */
public interface IDAO<T> {

    public boolean create(T item);

    public void read();

    public void update(T item, int index);

    public void delete(T item);

    public ArrayList<T> getList();

    public T getItem(int id);

}
