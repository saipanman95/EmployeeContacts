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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.id = :addressId"),
    @NamedQuery(name = "Address.findByAddressTypeId", query = "SELECT a FROM Address a WHERE a.addressTypeId = :addressTypeId"),
    @NamedQuery(name = "Address.findByStreet1", query = "SELECT a FROM Address a WHERE a.street1 = :street1"),
    @NamedQuery(name = "Address.findByStreet2", query = "SELECT a FROM Address a WHERE a.street2 = :street2"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByStateProv", query = "SELECT a FROM Address a WHERE a.stateProv = :stateProv"),
    @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = :zipcode"),
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")})
public class Address implements DatabaseObject, Serializable {

    private static final long serialVersionUID = 1L;
    private Integer addressId;
//    @NotNull
//    private int employeeId;
    private Employee employee;
    @NotNull
    private int addressTypeId;
    @NotNull
    @Size(min = 1, max = 155)
    private String street1;
    @NotNull
    @Size(min = 1, max = 155)
    private String street2;
    @NotNull
    @Size(min = 1, max = 255)
    private String city;
    @NotNull
    @Size(min = 1, max = 100)
    private String stateProv;
    @NotNull
    @Size(min = 1, max = 15)
    private String zipcode;
    @NotNull
    @Size(min = 1, max = 155)
    private String country;

    public Address() {
    }

    public Address(Integer addressId) {
        this.addressId = addressId;
    }

    public Address(Integer addressId,  int addressTypeId, String street1, String street2, String city, String stateProv, String zipcode, String country) {
        this.addressId = addressId;
//        this.employeeId = employeeId;
        this.addressTypeId = addressTypeId;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.stateProv = stateProv;
        this.zipcode = zipcode;
        this.country = country;
    }

    @Override
    public String getAllNamedQuery() {
        return "Address.findAll";
    }

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDRESS_ID", nullable = false)
    @Override
    public Integer getId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

//    @Basic(optional = false)
//    @Column(name = "EMPLOYEE_ID", nullable = false)
//    public int getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
    @Basic(optional = false)
    @Column(name = "ADDRESS_TYPE_ID", nullable = false)
    public int getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(int addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    @Basic(optional = false)
    @Column(name = "STREET_1", nullable = false, length = 155)
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    @Basic(optional = false)
    @Column(name = "STREET_2", nullable = false, length = 155)
    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic(optional = false)
    @Column(name = "STATE_PROV", nullable = false, length = 100)
    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }

    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic(optional = false)
    @Column(nullable = false, length = 155)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Address[ addressId=" + addressId + " ]";
    }

    @Override
    public void setId(Integer id) {
        this.addressId = id;
    }
}
