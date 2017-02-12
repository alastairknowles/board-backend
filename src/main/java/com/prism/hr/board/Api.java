package com.prism.hr.board;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@Controller
public class Api {
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @RequestMapping(value = {"/register", "/login", "/forgot", "/logout"}, method = RequestMethod.GET)
    public void suppressStormpathMvcViews(HttpServletResponse response) {
    }
    
}
