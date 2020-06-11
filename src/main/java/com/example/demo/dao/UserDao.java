package com.example.demo.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.User;
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
		return jdbcTemplate.queryForObject("SELECT * FROM users where login_id = ?", User.class,new UserRowMapper(),loginId);
	}


	
}
