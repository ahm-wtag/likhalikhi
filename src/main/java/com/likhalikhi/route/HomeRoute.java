package com.likhalikhi.route;

import com.likhalikhi.model.Customer;
import com.likhalikhi.model.Post;
import com.likhalikhi.service.CustomerService;
import com.likhalikhi.service.PostService;
import com.likhalikhi.service.SessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeRoute {

    static final Logger log = Logger.getLogger(HomeRoute.class);

    @Autowired
    PostService postService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/")
    public ModelAndView home( @CookieValue( name = "sc", defaultValue = "null") String session_id ) {

        ModelAndView mv = new ModelAndView("index.jsp");
        List <Post> posts = postService.findAll();

        try {
            if (!session_id.equals("null")) {
                UUID sessionID = UUID.fromString(session_id);
                Long customerId = sessionService.findUserSession(sessionID);
                Customer customer = customerService.findById(customerId);
                mv.addObject("name", customer.getFirstName());
            }
        } catch ( NoResultException | IllegalArgumentException e ) {
            log.warn("Malformed 'sc' cookie submitted");
            return new ModelAndView("redirect:/logout");
        }

        mv.addObject("posts",posts);
        return mv;
    }



}
