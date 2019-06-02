/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author user
 */
@Path("login")
public class LoginResource {

    @Autowired
    @Qualifier("JdbcLoginServiceImpl")
    private LoginService loginService = null;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @POST
    public String login(@FormParam("id") String id, @FormParam("password") String password) {
        System.out.println(id + password);
        return this.loginService.login(id, password);

    }

    @DELETE
    @Path("id")
    public boolean logout(@FormParam("id") String id) {
        return this.loginService.logout(id);
    }

}
