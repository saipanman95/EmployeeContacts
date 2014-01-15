/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.dao;

import com.mdrsolutions.web.contacts.entity.Employee;
import java.util.Date;
import java.util.List;

/**
 *
 * @author michael
 */
public interface EmployeeDAO extends DAOBase{
    List<Employee> findEmployeesHiredDateRange(Date startDt, Date endDt);

    List<Employee> findEmployeeByName(String lastName, String firstName);

    List<Employee> findEmployeeByAddress(String address);

    List<Employee> findEmployeeBetweenDates(Date fromDt, Date toDt);
}
