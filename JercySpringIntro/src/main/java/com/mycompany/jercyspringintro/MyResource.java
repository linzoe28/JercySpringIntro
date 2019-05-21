package com.mycompany.jercyspringintro;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
@Path("test")
public class MyResource {

    @Autowired
    private TestComponent testComponent;

    public void setTestComponent(TestComponent testComponent) {
        this.testComponent = testComponent;
    }
    @GET
    public String getText() {
        return testComponent.getValue();
    }
}
