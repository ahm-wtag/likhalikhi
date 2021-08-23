package com.likhalikhi.middleware;

import com.likhalikhi.model.Customer;
import com.likhalikhi.service.CustomerService;
import com.likhalikhi.service.SessionService;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


public class AuthenticationInterceptor implements HandlerInterceptor {

    static final Logger log = Logger.getLogger(AuthenticationInterceptor.class);

    @Autowired
    SessionService sessionService;

    @Autowired
    CustomerService customerService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.warn("in prehandle");
        try {
            UUID sessionId = getUUIDFromCookie(request);
            Long customerId = sessionService.findUserSession(sessionId);
            if (customerId == -1L) {
                response.sendRedirect("/login");
                return false;
            }
        } catch ( IllegalArgumentException e ) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

//    Cannot get postHandle ModelAndView to work.
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//
//        try {
//            UUID sessionID = getUUIDFromCookie(request);
//            Long customerId = sessionService.findUserSession(sessionID);
//            Customer customer = customerService.findById(customerId);
//            modelAndView.addObject("name", customer.getFirstName());
//        } catch ( NullPointerException exception ) {
//            response.sendRedirect("/logout");
//        }
//
//
//    }

    public UUID getUUIDFromCookie( HttpServletRequest request )  {
        Cookie[] cookies = request.getCookies();

        String uuid = "";
        for (Cookie cookie: cookies) {
            if ( cookie.getName().equals("sc") ) {
                uuid = cookie.getValue();
            }
        }
        return UUID.fromString(uuid);
    }


}
