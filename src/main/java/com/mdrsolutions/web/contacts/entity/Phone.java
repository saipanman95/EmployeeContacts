/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author michael
 */
@Entity
@Table(catalog = "CONTACTS", schema = "")
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p"),
    @NamedQuery(name = "Phone.findByPhoneId", query = "SELECT p FROM Phone p WHERE p.id = :phoneId"),
    @NamedQuery(name = "Phone.findByEmployeeId", query = "SELECT p FROM Phone p WHERE p.employeeId = :employeeId"),
    @NamedQuery(name = "Phone.findByPhoneTypeId", query = "SELECT p FROM Phone p WHERE p.phoneTypeId = :phoneTypeId"),
    @NamedQuery(name = "Phone.findByPhoneNumer", query = "SELECT p FROM Phone p WHERE p.phoneNumer = :phoneNumer")})
public class Phone implements DatabaseObject, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer phoneId;
    @NotNull
    private int employeeId;
    @NotNull
    private int phoneTypeId;
    @NotNull
    @Size(min = 1, max = 25)
    private String phoneNumer;

    public Phone() {
    }

    public Phone(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Phone(Integer phoneId, int employeeId, int phoneTypeId, String phoneNumer) {
        this.phoneId = phoneId;
        this.employeeId = employeeId;
        this.phoneTypeId = phoneTypeId;
        this.phoneNumer = phoneNumer;
    }

    @Override
    public String getAllNamedQuery() {
        return "Phone.findAll";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PHONE_ID", nullable = false)
    @Override
    public Integer getId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic(optional = false)
    @Column(name = "PHONE_TYPE_ID", nullable = false)
    public int getPhoneTypeId() {
        return phoneTypeId;
    }

    public void setPhoneTypeId(int phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
    }

    @Basic(optional = false)
    @Column(name = "PHONE_NUMER", nullable = false, length = 25)
    public String getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneId != null ? phoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.phoneId == null && other.phoneId != null) || (this.phoneId != null && !this.phoneId.equals(other.phoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Phone[ phoneId=" + phoneId + " ]";
    }

    @Override
    public void setId(Integer id) {
        this.phoneId = id;
    }
}
