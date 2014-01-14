/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author michael
 */
public interface PersistenceBase {
    
    void setEntityManagerFactory(EntityManagerFactory entityManagerFactory);
    
    public EntityManager getEntityManager();
}
