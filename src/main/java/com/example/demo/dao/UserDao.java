package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.User;
import com.example.demo.rowmapper.UserRowMapper;

@Repository
public class UserDao {

	private static Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/myOAuth?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@123");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User getUserByLoginId(String loginId) {
		logger.info("Getting user detail from SQL");
		User user = null;
		try {
			user = jdbcTemplate.queryForObject("SELECT * FROM users where login_id = ?",new UserRowMapper(),  loginId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}


	
}
