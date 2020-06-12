package com.example.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.bean.Role;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Role role = new Role();
    	role.setRole_id(rs.getInt("role_id"));
    	role.setRole(rs.getString("role"));
    	return role;
    	
    }

}
