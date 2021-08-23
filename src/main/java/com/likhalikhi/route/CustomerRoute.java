package com.likhalikhi.route;

import com.likhalikhi.controller.CustomerController;
import com.likhalikhi.model.Customer;
import com.likhalikhi.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerRoute {
    @Autowired
    CustomerService service;
    private final String API_URL =  "http://localhost:8080/api/customers";
    static final Logger log = Logger.getLogger(CustomerController.class);

    @PostMapping("/customers")
    public String create(@ModelAttribute Customer customer) {
        log.debug("IT is here");
        RestTemplate restTemplate = new RestTemplate();

        try {
            Customer savedCustomer = restTemplate.postForObject(API_URL,customer,Customer.class);
        }catch (Exception e ) {
            return "redirect:/error";
        }

        return "redirect:/login";
    }
}
