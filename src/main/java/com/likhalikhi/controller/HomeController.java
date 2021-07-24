package com.likhalikhi.controller;

import com.likhalikhi.model.Post;
import com.likhalikhi.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    static final Logger log = Logger.getLogger(HomeController.class);

    @Autowired
    PostService service;


    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView("index.jsp");
        List <Post> posts = service.findAll();
        mv.addObject("posts",posts);
        return mv;
    }
}
