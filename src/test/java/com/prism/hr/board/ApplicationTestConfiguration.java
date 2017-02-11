package com.prism.hr.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prism.hr.board.rest.dto.RegistrationDTO;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.mvc.WebHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationTestConfiguration {
    
    private static Integer USER_INDEX = 0;
    
    private static Map<String, RegistrationDTO> USER_CACHE = new HashMap<>();
    
    private ObjectMapper objectMapper;
    
    @Autowired
    public ApplicationTestConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    
    @Bean
    public WebHandler registerPostHandler() {
        return (request, response, account) -> {
            if (request.getRequestURL().toString().endsWith("/register")) {
                try {
                    RegistrationDTO registrationDTO = objectMapper.readValue(request.getReader(), RegistrationDTO.class);
                    registrationDTO.setAccessTokens(account.getAccessTokens());
                    USER_CACHE.put(registrationDTO.getEmail(), registrationDTO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            return true;
        };
    }
    
    public static synchronized Integer getUserIndex() {
        USER_INDEX = USER_INDEX + 1;
        return USER_INDEX;
    }
    
    Map<String, RegistrationDTO> getUserCache() {
        return USER_CACHE;
    }
    
}
