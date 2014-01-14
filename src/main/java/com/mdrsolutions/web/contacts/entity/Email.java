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
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findByEmailId", query = "SELECT e FROM Email e WHERE e.id = :emailId"),
    @NamedQuery(name = "Email.findByEmployeeId", query = "SELECT e FROM Email e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "Email.findByEmailTypeId", query = "SELECT e FROM Email e WHERE e.emailTypeId = :emailTypeId"),
    @NamedQuery(name = "Email.findByEmailAddress", query = "SELECT e FROM Email e WHERE e.emailAddress = :emailAddress")})
public class Email implements DatabaseObject, Serializable {

    private static final long serialVersionUID = 1L;
    private Integer emailId;
    @NotNull
    private int employeeId;
    @NotNull
    private int emailTypeId;
    @NotNull
    @Size(min = 1, max = 150)
    private String emailAddress;

    public Email() {
    }

    public Email(Integer emailId) {
        this.emailId = emailId;
    }

    public Email(Integer emailId, int employeeId, int emailTypeId, String emailAddress) {
        this.emailId = emailId;
        this.employeeId = employeeId;
        this.emailTypeId = emailTypeId;
        this.emailAddress = emailAddress;
    }

    @Override
    public String getAllNamedQuery() {
        return "Email.findAll";
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMAIL_ID", nullable = false)
    public Integer getId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
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
    @Column(name = "EMAIL_TYPE_ID", nullable = false)
    public int getEmailTypeId() {
        return emailTypeId;
    }

    public void setEmailTypeId(int emailTypeId) {
        this.emailTypeId = emailTypeId;
    }

    @Basic(optional = false)
    @Column(name = "EMAIL_ADDRESS", nullable = false, length = 150)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailId != null ? emailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Email[ emailId=" + emailId + " ]";
    }

    @Override
    public void setId(Integer id) {
        this.emailId = id;
    }
}
