/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.controller;

import com.mdrsolutions.web.contacts.entity.Employee;
import com.mdrsolutions.web.contacts.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author michael
 */
@Controller
@RequestMapping("/pages")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Handles and retrieves the login JSP page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/employeeDirectory.html", method = RequestMethod.GET)
    public String getAllEmployees(ModelMap model) {
        List<Employee> allEmployees = employeeService.findAllEmployees();
        model.addAttribute("employees", allEmployees);

        return "/pages/employeeDirectory";

    }

    @RequestMapping(value = "/employeeInformation.html", method = RequestMethod.GET)
    public String getEmployeesDetails(@RequestParam Integer id, ModelMap model) {
        Employee employeeById = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employeeById);

        return "/pages/employeeInformation";

    }
    
    @RequestMapping(value = "/saveEmployeeDetails", method. RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute("employee") Employee employee, ModelMap model ){
        
        String updateMsg = "Employee Successfully Updated!";
        String createMsg = "Employee Successfully Created!";
        String errorMsg = "An Error has occured attempting to update or save Employee information; please contact your system administrator!";
        String validationErrorMsg = "Employee information is incomplete; please check to make sure form fields are filled out!";
        
        Map validationMap = validate(employee);
            
        if ( validationMap.containsKey("validated") ){
            employeeService.saveOrUpdate(employee);
        }
        
        return "/pages/employeeInformation"
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    private Map<String,String> validate(Employee employee){
        return employeeService.validate(employee);
    }
}
