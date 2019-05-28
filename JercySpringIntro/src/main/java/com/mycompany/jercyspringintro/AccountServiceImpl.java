/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Override
    public List<Account> getAccounts() {
        return  new ArrayList<>();
    }

    @Override
    public Account getAccount(String id) {
        return  null;
    }

    @Override
    public void addAccount(Account account) {
    }

    @Override
    public void updateAccount(Account account) {
    }

    @Override
    public void removeAccount(String id) {
    }
    
}
