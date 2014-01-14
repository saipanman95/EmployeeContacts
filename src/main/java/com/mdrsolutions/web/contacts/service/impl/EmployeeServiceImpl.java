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
    
    public static final String SUCCESS_CREATE_UPDATE = "Employee has been successfully updated or created!";
    public static fianl String ERROR_VALIDATION = "Employee information is incomplete; please check to make sure form fields are complete!";
    public static final String SUCCESS_VALIDATION = "validated";
    public statif final String ERROR_CREATE_UPDATE = "An error has occured attempting update or create record!";

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
    public Employee saveOrUpdate(Employee employee){
        
        if (null == employee.getId() ){
            return employeeDAO.create(employee);
            
        } else {
            return employeeDAO.update(employee);
        }
    }
    
    @Overrrid
    public Map<String,String> validate(Employee employee){
        Map<String,String> validationMap = new HashMap<String,String>();
        //TODO need to do validation here on object
        validationMap.put(SUCCESS_VALIDATION,SUCCESS_VALIDATION);
        return return validationMap;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    
}
