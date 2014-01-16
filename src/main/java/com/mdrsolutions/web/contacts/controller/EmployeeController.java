/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.controller;

import com.mdrsolutions.web.contacts.entity.Address;
import com.mdrsolutions.web.contacts.entity.Email;
import com.mdrsolutions.web.contacts.entity.Employee;
import com.mdrsolutions.web.contacts.entity.Lookup;
import com.mdrsolutions.web.contacts.entity.Phone;
import com.mdrsolutions.web.contacts.model.JqGridData;
import com.mdrsolutions.web.contacts.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = "/employeeDirectoryReset.html", method = RequestMethod.GET)
    public String getResetEmployeeSearch(ModelMap model) {
        List<Employee> employees = employeeService.findAllEmployees();

        model.addAttribute("employees", employees);

        return "/pages/employeeDirectory";
    }

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
                employees.add(employee);

            } else if (!lastName.isEmpty() || !firstName.isEmpty()) {
                employees = employeeService.findEmployeeByName(lastName, firstName);
            } else if (!address.isEmpty()) {
                employees = employeeService.findEmployeeByAddress(address);
            } else if (!toDt.isEmpty() && !fromDt.isEmpty()) {
                employees = employeeService.findEmployeeBetweenDates(fromDt, toDt);
            } else {
                employees = employeeService.findAllEmployees();
            }
        } else {
            employees = employeeService.findAllEmployees();
        }


        model.addAttribute("employees", employees);
        System.out.println(lastName);

        return "/pages/employeeDirectory";
    }

    @RequestMapping(value = "/employeeInformation.html", method = RequestMethod.GET)
    public String getEmployeesDetails(@RequestParam Integer id,
            @RequestParam(value = "type", required = false) String type,
            ModelMap model) {
        Employee empObj;
        if ( id != 0){
            empObj = employeeService.findEmployeeById(id);
        } else {
            empObj = new Employee(null);
        }
        
        if ( null != type){
            empObj = addChildEntity(type, empObj);
        }
        
        model.addAttribute("employee", empObj);
        //following used to determine if this is a new record for create
        if (0 != id) {
            model.addAttribute("oldrecord", true);
        } else {
            model.addAttribute("oldrecord", false);
        }

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

    @RequestMapping(value = "/saveEmployeeDetails.html", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap modelMap) {

        String updateMsg = "Employee Successfully Updated!";
        String createMsg = "Employee Successfully Created!";
        String errorMsg = "An Error has occured attempting to update or save Employee information; please contact your system administrator!";
        String validationErrorMsg = "Employee information is incomplete; please check to make sure form fields are filled out!";
        String message = null;
        Map validationMap = validate(employee);
        Integer id = 0;
        if (validationMap.containsKey("validated")) {


            if (null != employee.getId()) {
                id = employee.getId();
                message = updateMsg;
            } else {
                message = createMsg;
            }

            try {
                Employee emp = employeeService.saveOrUpdate(employee);
                id = emp.getId();
                modelMap.addAttribute("employee", emp);
                modelMap.addAttribute("message", message);
            } catch (Exception ex) {
                modelMap.addAttribute("employee", employee);
                modelMap.addAttribute("message", errorMsg);
            }
        } else {
            modelMap.addAttribute("employee", employee);
            modelMap.addAttribute("message", validationErrorMsg);
            id = employee.getId();
        }

        return "redirect:/pages/employeeInformation.html?id=" + id.toString();
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private Map<String, String> validate(Employee employee) {
        List<Address> addresses = employee.getAddresses();
        List<Email> emails = employee.getEmails();
        List<Phone> phoneNumbers = employee.getPhoneNumbers();

        if (null != addresses) {
            for (Address adr : addresses) {
                if (null == adr.getEmployeeId()) {
                    adr.setEmployee(new Employee(employee.getId()));
                }
            }
        }
        if (null != emails) {
            for (Email eml : emails) {
                if (null == eml.getEmployeeId()) {
                    eml.setEmployee(new Employee(employee.getId()));
                }
            }
        }
        if (null != phoneNumbers) {
            for (Phone ph : phoneNumbers) {
                if (null == ph.getEmployeeId()) {
                    ph.setEmployee(new Employee(employee.getId()));
                }
            }
        }
        return employeeService.validate(employee);
    }

    private Employee addChildEntity(String type, Employee emp) {
        if (type.equalsIgnoreCase("email")){
            emp.getEmails()
                    .add(new Email(null, new Employee(emp.getId()), null, null));
        } else if (type.equalsIgnoreCase("address")){
            emp.getAddresses()
                    .add(new Address(null, new Employee(emp.getId()), null));
            
        } else if (type.equalsIgnoreCase("phone")){
            emp.getPhoneNumbers()
                    .add(new Phone(null, new Employee(emp.getId()), null, null));
        }
        
        return emp;
    }
}
