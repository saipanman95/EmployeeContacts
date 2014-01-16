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
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p"),
    @NamedQuery(name = "Phone.findByPhoneId", query = "SELECT p FROM Phone p WHERE p.id = :phoneId"),
    @NamedQuery(name = "Phone.findByPhoneNumer", query = "SELECT p FROM Phone p WHERE p.phoneNumer = :phoneNumer")})
public class Phone implements DatabaseObject, Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Employee employee;
    private Lookup phoneType;    
    @Size(min = 1, max = 25)
    private String phoneNumer;

    public Phone() {
    }

    public Phone(Integer phoneId) {
        this.id = phoneId;
    }

    public Phone(Integer phoneId, Employee employee, Lookup phoneType, String phoneNumer) {
        this.id = phoneId;
        this.employee = employee;
        this.phoneType = (phoneType == null) ? new Lookup(1) : phoneType;
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
        return id;
    }

    public void setPhoneId(Integer phoneId) {
        this.id = phoneId;
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
    public String getPhoneTypeCd(){
        if ( phoneType != null){
            if (phoneType.getCode() != null){
                return phoneType.getCode().toLowerCase();
            }
        }
        return null;
    }
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PHONE_TYPE_ID", nullable = false)
    public Lookup getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(Lookup phoneType) {
        this.phoneType = phoneType;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Phone[ phoneId=" + id + " ]";
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
