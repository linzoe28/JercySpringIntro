/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

/**
 *
 * @author user
 */
public interface LoginService {

    public String login(String id, String password);
    public boolean logout(String id);
}
