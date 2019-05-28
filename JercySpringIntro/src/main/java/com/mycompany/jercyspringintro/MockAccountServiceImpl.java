/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service("mock")
public class MockAccountServiceImpl implements AccountService {

    private Map<String, Account> accounts = new HashMap<String, Account>();

    @Override
    public List<Account> getAccounts() {
        return new ArrayList<Account>(accounts.values());
    }

    @Override
    public Account getAccount(String id) {
        return accounts.get(id);
    }

    @Override
    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public void updateAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public void removeAccount(String id) {
        accounts.remove(id);
    }

}
