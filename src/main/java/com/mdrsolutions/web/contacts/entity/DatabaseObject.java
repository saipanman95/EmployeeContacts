/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.entity;

/**
 *
 * @author michael
 */
public interface DatabaseObject<T> {
    Integer getId();    
    void setId(Integer id);
    String getAllNamedQuery();
}
