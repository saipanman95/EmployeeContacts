/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    @NamedQuery(name = "Email.findByEmailAddress", query = "SELECT e FROM Email e WHERE e.emailAddress = :emailAddress")})
public class Email implements DatabaseObject, Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Employee employee;
    private Lookup emailType;
    @NotNull
    @Size(min = 1, max = 150)
    private String emailAddress;

    public Email() {
    }

    public Email(Integer emailId) {
        this.id = emailId;
    }

    public Email(Integer emailId, Employee employee, Lookup emailType, String emailAddress) {
        this.id = emailId;
        this.employee = employee;
        this.emailType = (emailType == null) ? new Lookup(1) : emailType;
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
        return id;
    }

    public void setEmailId(Integer emailId) {
        this.id = emailId;
    }

    @Transient
    public Integer getEmployeeId() {
        if (null != employee) {
            if (employee.getId() != null) {
                return employee.getId();
            }
        }
        return null;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Transient
    public String getEmailTypeCd() {
        if (emailType != null) {
            if (emailType.getCode() != null) {
                return emailType.getCode().toLowerCase();
            }
        }
        return null;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMAIL_TYPE_ID", nullable = false)
    public Lookup getEmailType() {
        return emailType;
    }

    public void setEmailType(Lookup emailType) {
        this.emailType = emailType;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Email[ emailId=" + id + " ]";
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
