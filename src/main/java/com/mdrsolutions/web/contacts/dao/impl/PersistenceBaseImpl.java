/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.dao.impl;

import com.mdrsolutions.web.contacts.dao.PersistenceBase;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michael
 */
@Repository("persistenceBase")
public class PersistenceBaseImpl implements PersistenceBase{
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    private EntityManager entityManager;

    @Override
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    @Override
    public EntityManager getEntityManager(){
        if ( null == entityManager){
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
    
   
    
    
}
