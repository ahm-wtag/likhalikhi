package com.likhalikhi.controller;

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

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class HomeController {

    static final Logger log = Logger.getLogger(HomeController.class);

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

        if ( !session_id.equals("null") ) {
            UUID sessionID = UUID.fromString(session_id);
            Long id = sessionService.findUserSession(sessionID);
            Customer customer =  customerService.findById(id);
            mv.addObject("name",customer.getFirstName());
        }



        mv.addObject("posts",posts);
        return mv;
    }



}
