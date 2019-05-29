/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author User
 */
@Path("accounts")
public class AccountResource {
    @Autowired
    @Qualifier("jdbc")
    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("id") String id){
      return this.accountService.getAccount(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAccount(Account account){
      this.accountService.addAccount(account);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public  void updateAccount(Account account){
       this.accountService.updateAccount(account);
    }
    
    @DELETE
    @Path("{id}")
    public void removeAccount(@PathParam("id") String id){
      this.accountService.removeAccount(id);
    }
    
}
