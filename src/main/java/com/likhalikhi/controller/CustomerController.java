package com.likhalikhi.controller;

import com.likhalikhi.model.Customer;
import com.likhalikhi.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    @Autowired
    CustomerService service;

    static final Logger log = Logger.getLogger(CustomerController.class);

    @PostMapping("/customer")
    public String create(HttpServletRequest request) {

        Customer customer = new Customer();

        customer.setHandle(request.getParameter("handle"));
        customer.setEmail(request.getParameter("email"));
        customer.setPassword(request.getParameter("password"));
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));

//        log.warn(customer);

        service.save(customer);

        return "redirect:/login";
    }

}
