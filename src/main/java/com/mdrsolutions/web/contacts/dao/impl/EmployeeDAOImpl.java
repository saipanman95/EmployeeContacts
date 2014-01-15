/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.dao.impl;

import com.mdrsolutions.web.contacts.dao.EmployeeDAO;
import com.mdrsolutions.web.contacts.entity.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository("employeeDAO")
public class EmployeeDAOImpl extends DAOBaseImpl implements EmployeeDAO {

    @Override
    public List<Employee> findEmployeesHiredDateRange(Date startDt, Date endDt) {
        TypedQuery<Employee> typedNamedQuery = getEntityManager().createNamedQuery("Employee.findByHiredDateRange", Employee.class);
        typedNamedQuery.setParameter("startDt", startDt);
        typedNamedQuery.setParameter("endDate", endDt);
        return typedNamedQuery.getResultList();
    }

    @Override
    public List<Employee> findEmployeeByName(String lastName, String firstName) {
        Query nq = getEntityManager().createNamedQuery("Employee.findByFirstNameLastNameLike");
        String lName = (lastName == null)? null : (lastName.isEmpty())? null :"%" + lastName + "%";
        String fName = (firstName == null)? null : (firstName.isEmpty())? null :"%" + firstName + "%";
        nq.setParameter("lastName", lName);
        nq.setParameter("firstName", fName);
        return nq.getResultList();
    }

    @Override
    public List<Employee> findEmployeeByAddress(String address) {
        Query nq = getEntityManager().createNamedQuery("Employee.findByAddressLike");
        String addr = (address == null) ? null : (address.isEmpty())? null : "%" + address + "%";
        nq.setParameter("street1", addr);
        return nq.getResultList();
    }

    @Override
    public List<Employee> findEmployeeBetweenDates(Date fromDt, Date toDt) {        
        return findEmployeesHiredDateRange(fromDt, toDt);
    }
}
