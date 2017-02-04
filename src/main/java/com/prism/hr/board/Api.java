package com.prism.hr.board;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Api {
    
    private AccountResolver accountResolver = AccountResolver.INSTANCE;
    
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String api(HttpServletRequest request) {
        Account account = accountResolver.getAccount(request);
        if (account == null) {
            return "redirect:/login?next=api";
        }
        
        return "api";
    }
    
}
