package com.example.demo.rowmapper;

import com.example.demo.bean.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_first_name(rs.getString("user_first_name"));
        user.setUser_last_name(rs.getString("user_last_name"));
        user.setLogin_id(rs.getString("login_id"));
        user.setPasswd(rs.getString("passwd"));
        user.setActive(rs.getBoolean("active"));

        return user;
    }
}
