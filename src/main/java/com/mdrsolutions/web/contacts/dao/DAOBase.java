/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.dao;

import com.mdrsolutions.web.contacts.entity.DatabaseObject;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author michael
 */
public interface DAOBase<T extends DatabaseObject> {
 
    EntityManager getEntityManager();
    
    List<T> findAll(T t);
    T findById(T t, int id);
    
    T update(T t);
    T create(T t);
    void delete(T t);
}
