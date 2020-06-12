package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.rowmapper.RoleRowMapper;
import com.example.demo.rowmapper.UserRowMapper;

@Repository
public class UserDao {

	private static Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	public User getUserByLoginId(String loginId) {
		logger.info("Getting user detail from SQL");
		User user = null;
		try {
			user = jdbcTemplate.queryForObject("SELECT * FROM users where login_id = ?",new UserRowMapper(),  loginId);
		} catch (Exception e) {
			logger.error("error",e);
		}
		
		return user;
	}
	
	public List<Role> getRoleForLoginId(String loginId) {
		String sql = 
				"select r.role_id, r.role "
				+ " from users u "
				+ " left join user_role ur "
					+ " on u.user_id=ur.user_id "
				+ " left join roles r "
					+ " on ur.role_id = r.role_id "
					+ " where login_id = ? "
					+ " and role is not null; ";
		List<Role> roles = new ArrayList<>();
		try {
			roles = jdbcTemplate.query(sql, new RoleRowMapper(), loginId);
		} catch(EmptyResultDataAccessException e) {
			logger.error("Exception", e);
		}
		return roles;
	}


	
}
