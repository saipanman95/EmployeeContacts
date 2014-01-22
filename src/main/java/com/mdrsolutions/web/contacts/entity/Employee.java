/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

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
    @NamedQuery(name = "Employee.findByAddressLike", query = "SELECT e FROM Employee e INNER JOIN e.addresses AS addr WHERE addr.street1 LIKE :street1"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByFirstNameLastNameLike", query = "SELECT e FROM Employee e WHERE e.firstName LIKE :firstName OR e.lastName LIKE :lastName"),
    @NamedQuery(name = "Employee.findByMiddleName", query = "SELECT e FROM Employee e WHERE e.middleName = :middleName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findBySuffix", query = "SELECT e FROM Employee e WHERE e.suffix = :suffix"),
    @NamedQuery(name = "Employee.findByHiredDateRange", query = "SELECT e FROM Employee e WHERE e.hiredDate BETWEEN :startDate AND :endDate")})
public class Employee implements PaginatedList, DatabaseObject, Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
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
    private String hiredDateStr;
    private List<Address> addresses;
    private List<Phone> phoneNumbers;
    private List<Email> emails;
    private String stringifiedAddress;
    private String stringifiedEmails;
    private String stringifiedPhoneNumbers;

    public Employee() {
    }

    @Override
    public String getAllNamedQuery() {
        return "Employee.findAll";
    }

    public Employee(Integer employeeId) {
        this.id = employeeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID", nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    public void setPersonId(Integer employeeId) {
        this.id = employeeId;
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

    @Column(name = "HIRED_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    @Transient
    public String getHiredDateStr() {
        if (null != getHiredDate()){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            hiredDateStr = df.format(hiredDate);
        }
        return hiredDateStr;
    }

    public void setHiredDateStr(String hiredDateStr) {
        this.hiredDateStr = hiredDateStr;
    }

    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Transient
    public String getStringifiedAddress() {
        List<Address> addys = getAddresses();
        StringBuilder sb = new StringBuilder();
        if (null == addys) {
            return "";
        }
        for (Address adrs : addys) {
            sb.append(" ");
            sb.append(adrs.getAddressTypeCd()).append(": ");
            sb.append(adrs.getStreet1()).append(" ");
            sb.append(adrs.getStreet2()).append(" ");
            sb.append(adrs.getCity()).append(" ");
            sb.append(adrs.getStateProv()).append(" ");
            sb.append(adrs.getZipcode()).append(" ");
            sb.append(adrs.getCountry()).append(" ");
            sb.append("<br/>");
        }
        return sb.toString();
    }

    @Transient
    public String getStringifiedEmails() {
        List<Email> ems = getEmails();
        StringBuilder sb = new StringBuilder();
        if (null == ems) {
            return "";
        }
        for (Email em : ems) {
            sb.append(" ");
            sb.append(em.getEmailTypeCd()).append(": ");
            sb.append(em.getEmailAddress()).append("<br/>");
        }
        return sb.toString();
    }

    @Transient
    public String getStringifiedPhoneNumbers() {
        List<Phone> phs = getPhoneNumbers();
        StringBuilder sb = new StringBuilder();
        if (null == phs) {
            return "";
        }
        for (Phone ph : phs) {
            sb.append(" ");
            sb.append(ph.getPhoneTypeCd()).append(": ");
            sb.append(ph.getPhoneNumer()).append("<br/>");
        }
        return sb.toString();
    }

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Employee[ employeeId=" + id + " ]";
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    @Override
    public List getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transient
    @Override
    public int getPageNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transient
    @Override
    public int getObjectsPerPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transient
    @Override
    public int getFullListSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transient
    @Override
    public String getSortCriterion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transient
    @Override
    public SortOrderEnum getSortDirection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transient
    @Override
    public String getSearchId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
