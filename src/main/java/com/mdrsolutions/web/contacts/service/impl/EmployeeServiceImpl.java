/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.service.impl;

import com.mdrsolutions.web.contacts.dao.EmployeeDAO;
import com.mdrsolutions.web.contacts.entity.Employee;
import com.mdrsolutions.web.contacts.service.EmployeeService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    
    @Override
    public List<Employee> findAllEmployees() {
        Employee e = new Employee();
        return employeeDAO.findAll(e);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee e = new Employee();
        return (Employee) employeeDAO.findById(e, id);
    }

    @Override
    public List<Employee> findEmployeeHiredByDateRange(Date startDt, Date endDt) {
        return employeeDAO.findEmployeesHiredDateRange(startDt, endDt);
    }
    
    @Override
    public void saveOrUpdate(Employee employee){
        
        if (null == employee.getId() ){
            employeeDAO.save(employee);
            
        } else {
            employeeDAO.update(employee);
        }
    }
    
    @Overrrid
    public Map<String,String> validate(Employee employee){
        return new HashMap<String,String>();
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    
}
