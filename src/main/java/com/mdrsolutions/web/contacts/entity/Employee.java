/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author michael
 */
@Entity
@Table(catalog = "CONTACTS", schema = "")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.id = :employeeId"),
    @NamedQuery(name = "Employee.findByTitle", query = "SELECT e FROM Employee e WHERE e.title = :title"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByMiddleName", query = "SELECT e FROM Employee e WHERE e.middleName = :middleName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findBySuffix", query = "SELECT e FROM Employee e WHERE e.suffix = :suffix"),
    @NamedQuery(name = "Employee.findByHiredDateRange", query = "SELECT e FROM Employee e WHERE e.hiredDate BETWEEN :startDt AND :endDate")})
public class Employee implements DatabaseObject, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer employeeId;
    @Size(max = 25)
    private String title;
    @Size(max = 25)
    private String firstName;
    @Size(max = 25)
    private String middleName;
    @Size(max = 25)
    private String lastName;
    @Size(max = 25)
    private String suffix;
    @NotNull
    private Date hiredDate;
    
    private List<Address> addresses;
    

    public Employee() {
    }

    @Override
    public String getAllNamedQuery(){
        return "Employee.findAll";
    }
    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID", nullable = false)
    @Override
    public Integer getId() {
        return employeeId;
    }

    public void setPersonId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Column(length = 25)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "FIRST_NAME", length = 25)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "MIDDLE_NAME", length = 25)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "LAST_NAME", length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(length = 25)
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Column(name="HIRED_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    @OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Employee[ employeeId=" + employeeId + " ]";
    }

    @Override
    public void setId(Integer id) {
        this.employeeId = id;
    }
    
}
