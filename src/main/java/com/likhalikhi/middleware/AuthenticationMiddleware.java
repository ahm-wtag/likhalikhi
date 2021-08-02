package com.likhalikhi.middleware;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AuthenticationMiddleware implements HandlerInterceptor {

    static final Logger log = Logger.getLogger(AuthenticationMiddleware.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();

        String uuid = "";
        for (Cookie cookie: cookies) {
            if ( cookie.getName().equals("sc") ) {
                uuid = cookie.getValue();
            }
        }



        if ( uuid.equals("") ) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
