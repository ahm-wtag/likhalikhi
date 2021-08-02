package com.likhalikhi.controller;

import com.likhalikhi.model.Post;
import com.likhalikhi.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService service;

    static final Logger log =  Logger.getLogger(PostController.class);

    @GetMapping("/posts")
    public List<Post> findAll() {
        return service.findAll();
    }

    @PostMapping("/posts")
    public RedirectView create(HttpServletRequest request ) {
        Post post = new Post(request.getParameter("title"),request.getParameter("body"));
        service.save(post);
        return new RedirectView("/");
    }

    @PostMapping("/posts/new")
    public String showForm() {
        return "post/post-form.jsp";
    }


// TODO implement update and delete feature
// TODO find users by session and establish the many to many between customer and post

}
