package com.likhalikhi.controller;

import com.likhalikhi.model.Customer;
import com.likhalikhi.model.Session;
import com.likhalikhi.service.CustomerService;
import com.likhalikhi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class SessionController {

    @Autowired
    CustomerService customerService;

    @Autowired
    SessionService sessionService;


    @GetMapping("/login")
    public String login() {
        return "authentication/login.jsp";
    }

    @GetMapping("/register")
    public String register() {
        return "authentication/register.jsp";
    }

    @PostMapping("/session")
    public String create(HttpServletRequest request, RedirectAttributes attributes, HttpServletResponse response ) {
        String handle =  request.getParameter("handle");
        String password = request.getParameter("password");

        Customer customer = customerService.findByHandle(handle);

        if ( !customer.getPassword().equals(password) ) {
            attributes.addFlashAttribute("error","Wrong credentials");
            return "redirect:/login";
        }

        Session session = new Session();
        session.setCustomer_id(customer.getId());
        UUID sessionId =  sessionService.save(session);

        Cookie cookie = new Cookie("sc",sessionId.toString());
        response.addCookie(cookie);

        return "redirect:/";
    }


//    TODO implement logout feature

}
