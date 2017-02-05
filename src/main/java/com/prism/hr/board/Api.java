package com.prism.hr.board;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class Api {
    
    @RequestMapping(value = {"/register", "/login", "/forgot"}, method = RequestMethod.GET, headers = "Accept=text/html")
    public String authentication(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setHeader("Pragma", "no-cache");
        return "forward:/";
    }
    
}
