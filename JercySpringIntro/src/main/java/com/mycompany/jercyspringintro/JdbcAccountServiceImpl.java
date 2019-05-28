/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service("jdbc")
public class JdbcAccountServiceImpl implements AccountService{
    @Autowired
    private  JdbcTemplate jdbcTemplate=null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

    @Override
    public List<Account> getAccounts() {
         /*List<Account> ret=new ArrayList<>();
         SqlRowSet rowSet= jdbcTemplate.queryForRowSet("select * from account");
         while(rowSet.next()){
             Account account=new Account();
             account.setId(rowSet.getString("id"));
             account.setId(rowSet.getString("password"));
             account.setId(rowSet.getString("email"));
             ret.add(account);
         }
         return ret;*/
         return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper(Account.class));
    }

    @Override
    public Account getAccount(String id) {
        return jdbcTemplate.queryForObject("select * from account where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public void addAccount(Account account) {
       jdbcTemplate.update("insert into account(id,password,email) values(?,?,?)",
               account.getId(),account.getPassword(),account.getEmail());
    }

    @Override
    public void updateAccount(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAccount(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
