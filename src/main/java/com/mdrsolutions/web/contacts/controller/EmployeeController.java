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

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}