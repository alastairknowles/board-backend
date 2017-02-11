package com.prism.hr.board.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stormpath.sdk.oauth.AccessTokenList;

public class RegistrationDTO {
    
    private String givenName;
    
    private String surname;
    
    private String email;
    
    private String password;
    
    @JsonIgnore
    private AccessTokenList accessTokens;
    
    public String getGivenName() {
        return givenName;
    }
    
    public RegistrationDTO setGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public RegistrationDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    
    public String getEmail() {
        return email;
    }
    
    public RegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public String getPassword() {
        return password;
    }
    
    public RegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public AccessTokenList getAccessTokens() {
        return accessTokens;
    }
    
    public RegistrationDTO setAccessTokens(AccessTokenList accessTokens) {
        this.accessTokens = accessTokens;
        return this;
    }
    
}
