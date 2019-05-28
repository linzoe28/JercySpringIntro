/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

import java.util.List;

/**
 *
 * @author User
 */
public interface AccountService {

    public List<Account> getAccounts();

    public Account getAccount(String id);

    public void addAccount(Account account);

    public void updateAccount(Account account);

    public void removeAccount(String id);
}
