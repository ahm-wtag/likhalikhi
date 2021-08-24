package com.likhalikhi.route;


import com.likhalikhi.exception.ApiRequestException;
import com.likhalikhi.model.Customer;
import com.likhalikhi.model.Session;
import com.likhalikhi.service.CustomerService;
import com.likhalikhi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.NoResultException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class SessionRoute {

    @Autowired
    CustomerService customerService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public String login(@CookieValue(name = "sc", defaultValue = "") String sessionId, RedirectAttributes redirectAttributes ) {
        if ( sessionId.length() != 0 ) {
            return "redirect:/";
        }
        return "authentication/login.jsp";
    }

    @GetMapping("/register")
    public String register() {
        return "authentication/register.jsp";
    }

    @PostMapping("/session")
    public String create(HttpServletRequest request, RedirectAttributes attributes, HttpServletResponse response, @ModelAttribute("error") String error, Model model ) {
        String handle =  request.getParameter("handle");
        String password = request.getParameter("password");
        model.addAttribute(error);
        try {
            Customer customer = customerService.findByHandle(handle);

            if (!customer.getPassword().equals(password)) {
                attributes.addFlashAttribute("error", "Wrong credentials");
                return "redirect:/login";
            }

            Session session = new Session();
            session.setCustomer_id(customer.getId());
            UUID sessionId = sessionService.save(session);
            Cookie cookie = new Cookie("sc",sessionId.toString());
            response.addCookie(cookie);
        }catch (Exception e ) {
            attributes.addFlashAttribute("error","Wrong Credentials");
            return "redirect:/login";
        }

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout( HttpServletRequest request, HttpServletResponse response ) {
        Cookie[] cookies = request.getCookies();
        try {
            for ( Cookie cookie: cookies ) {
                String uuid=cookie.getValue();
                if ( cookie.getName().equals("sc") ) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    UUID sessionId = UUID.fromString(uuid);
                    sessionService.delete(sessionId);
                }
            }
        } catch ( NoResultException e ) {
            return "redirect:/";
        } catch ( IllegalArgumentException e ) {
//            front request exception
        }
        return "redirect:/";
    }





}
