package com.mycompany.jercyspringintro;


import org.springframework.stereotype.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
@Component
public class TestComponent {
    public String getValue(){
       return "test";
    }
}
