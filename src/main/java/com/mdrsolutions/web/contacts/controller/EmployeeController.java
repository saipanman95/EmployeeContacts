/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.controller;

import com.mdrsolutions.web.contacts.entity.Employee;
import com.mdrsolutions.web.contacts.model.JqGridData;
import com.mdrsolutions.web.contacts.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String getAllEmployees(@RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "fromDt", required = false) String fromDt,
            @RequestParam(value = "toDt", required = false) String toDt,
            ModelMap model) {
        List<Employee> employees = new ArrayList<Employee>();
        if (id != null || lastName != null || firstName != null || address != null || toDt != null || fromDt != null) {
            if (id != null) {
                Employee employee = employeeService.findEmployeeById(id);
                if (employee == null) {
                    employees.add(new Employee());
                } else {
                    employees.add(employee);
                }
            } else if (!lastName.isEmpty() || !firstName.isEmpty()) {
                employees = employeeService.findEmployeeByName(lastName, firstName);
            } else if ( !address.isEmpty()) {
                employees = employeeService.findEmployeeByAddress(address);
            } else if (!toDt.isEmpty() && !fromDt.isEmpty()) {
                employees = employeeService.findEmployeeBetweenDates(fromDt, toDt);
            } else {
                employees = employeeService.findAllEmployees();
            }
        } else {
            employees = employeeService.findAllEmployees();
        }
        

        model.addAttribute(
                "employees", employees);
        System.out.println(lastName);

        return "/pages/employeeDirectory";
    }

    @RequestMapping(value = "/employeeInformation.html", method = RequestMethod.GET)
    public String getEmployeesDetails(@RequestParam Integer id, ModelMap model) {
        Employee employeeById = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employeeById);

        return "/pages/employeeInformation";

    }

    @RequestMapping(value = "/searchEmployee.html", method = RequestMethod.POST)
    public String filterEmployeeDirectory(@RequestParam Integer id,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String address,
            @RequestParam String fromDt,
            @RequestParam String toDt,
            ModelMap model) {
        Employee employees = employeeService.findEmployeeById(id);
        model.addAttribute("employees", employees);
        System.out.println(lastName);
        return "/pages/employeeDirectory";

    }

    @RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute("employee") Employee employee, ModelMap model) {

        String updateMsg = "Employee Successfully Updated!";
        String createMsg = "Employee Successfully Created!";
        String errorMsg = "An Error has occured attempting to update or save Employee information; please contact your system administrator!";
        String validationErrorMsg = "Employee information is incomplete; please check to make sure form fields are filled out!";

        Map validationMap = validate(employee);

        if (validationMap.containsKey("validated")) {
            employeeService.saveOrUpdate(employee);
        }

        return "/pages/employeeInformation";
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private Map<String, String> validate(Employee employee) {
        return employeeService.validate(employee);
    }
}
