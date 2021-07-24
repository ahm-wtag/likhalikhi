package com.likhalikhi.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    static final Logger log = Logger.getLogger(HomeController.class);

    @GetMapping("/")
    public String home() {
        log.debug("from home controller");
        return "index.jsp";
    }
}
