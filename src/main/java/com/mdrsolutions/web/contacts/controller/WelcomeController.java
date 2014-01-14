/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

/**
 *
 * @author michael
 */
@Controller
@RequestMapping("/pages")
public class WelcomeController {

    /**
     * Handles and retrieves the login JSP page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/welcome.html", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        
        model.addAttribute("message", "Welcome to Employee Search Page");
        
        return "/pages/welcome";

    }
}