/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jercyspringintro;

import java.util.UUID;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author user
 */

@Service("JdbcLoginServiceImpl")
public class JdbcLoginServiceImpl implements LoginService {
    @Autowired
    private JdbcTemplate JdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate JdbcTemplate) {
        this.JdbcTemplate = JdbcTemplate;
    }

    @Override
    public String login(String id, String password) {
        SqlRowSet rowSet = JdbcTemplate.queryForRowSet("select * from account where id=? and password=?", id, password);
        if (rowSet.next()) {
            String token = UUID.randomUUID().toString();
            JdbcTemplate.update("insert into login(account,token) values(?,?)", id, token);
            return token;
        }
        return null;
    }

    @Override
    public boolean logout(String id) {
        int ret = JdbcTemplate.update("delete from login where account=?", id);
        return ret > 0;
    }

}
