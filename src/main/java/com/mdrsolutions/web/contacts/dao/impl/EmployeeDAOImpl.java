/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.dao.impl;

import com.mdrsolutions.web.contacts.dao.EmployeeDAO;
import com.mdrsolutions.web.contacts.entity.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository("employeeDAO")
public class EmployeeDAOImpl extends DAOBaseImpl implements EmployeeDAO {

    @Override
    public List<Employee> findEmployeesHiredDateRange(Date startDt, Date endDt) {
        TypedQuery<Employee> typedNamedQuery = getEntityManager().createNamedQuery("findByHiredDateRange", Employee.class);
        typedNamedQuery.setParameter("startDt", startDt);
        typedNamedQuery.setParameter("endDt", endDt);
        return typedNamedQuery.getResultList();
    }
}
