package com.example.classic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SettlementService {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService){
        this.accountService = accountService;
    }
    public String settle(){
        return accountService.account()+ "<br/>i'm settlement service";
    }
}
