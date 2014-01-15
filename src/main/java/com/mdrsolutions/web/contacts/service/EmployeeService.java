/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.service;

import com.mdrsolutions.web.contacts.entity.Employee;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author michael
 */
public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee findEmployeeById(Integer id);

    List<Employee> findEmployeeHiredByDateRange(Date startDt, Date endDt);
    
    Employee saveOrUpdate(Employee employee); 
    
    Map<String, String> validate(Employee employee); 

    List<Employee> findEmployeeByName(String lastName, String firstName);

    public List<Employee> findEmployeeByAddress(String address);

    public List<Employee> findEmployeeBetweenDates(String fromDt, String toDt);
}
