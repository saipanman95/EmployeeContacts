/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.dao.impl;

import com.mdrsolutions.web.contacts.dao.DAOBase;
import com.mdrsolutions.web.contacts.dao.PersistenceBase;
import com.mdrsolutions.web.contacts.entity.DatabaseObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("daoBase")
public class DAOBaseImpl<T extends DatabaseObject> implements DAOBase<T> {

    @Autowired
    private PersistenceBase persistenceBase;

    public void setPersistenceBase(PersistenceBase persistenceBase) {
        this.persistenceBase = persistenceBase;
    }
    
    
            
    @Override
    public List<T> findAll(T t) {
        TypedQuery<? extends Object> createQuery = getEntityManager().createNamedQuery(t.getAllNamedQuery(), t.getClass());
        return (List<T>) createQuery.getResultList();
    }

    @Override
    public T findById(T t, int id) {
        return (T) getEntityManager().find(t.getClass(), id);
    }

    @Override
    public T update(T t) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(t);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
        return t;
    }

    @Override
    public T create(T t) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(t);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
        return t;
    }

    @Override
    public void delete(T t) {
        getEntityManager().remove(t);
    }

    @Override
    public EntityManager getEntityManager() {
        return persistenceBase.getEntityManager();
    }
    
}
