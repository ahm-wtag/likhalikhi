package com.likhalikhi.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorRoute {

    @GetMapping("/error")
    public String errorView() {
        return "error/error.jsp";
    }
}
