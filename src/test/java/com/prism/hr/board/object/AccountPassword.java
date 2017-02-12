package com.prism.hr.board.object;

import com.stormpath.sdk.account.Account;

public class AccountPassword {
    
    private Account account;
    
    private String password;
    
    public Account getAccount() {
        return account;
    }
    
    public AccountPassword setAccount(Account account) {
        this.account = account;
        return this;
    }
    
    public String getPassword() {
        return password;
    }
    
    public AccountPassword setPassword(String password) {
        this.password = password;
        return this;
    }
    
}
