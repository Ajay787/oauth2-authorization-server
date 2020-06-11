package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserByLoginId(String loginId) {
		User user = userDao.getUserByLoginId(loginId);
		if(user==null) {
			return null;
		}
		Set<Role> roles= new HashSet<Role>();
		Role role = new Role();
		role.setRole_id(1);
		role.setRole("ROLE_ADMIN");
		roles.add(role);
		user.setRoles(roles);
		
		return user;
		
	}
	
}
