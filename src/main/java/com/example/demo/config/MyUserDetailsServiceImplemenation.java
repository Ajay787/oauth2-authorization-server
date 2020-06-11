package com.example.demo.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Role;
import com.example.demo.service.UserService;

@Configuration
//@Component
@Service("userDetailsService")
public class MyUserDetailsServiceImplemenation implements UserDetailsService{

	@Autowired
	private UserService userService;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.bean.User foundUser = userService.getUserByLoginId(username);


		if(foundUser==null){
			throw new UsernameNotFoundException("User"+username+"can not be found");
		}

		List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
		for(Role role:foundUser.getRoles()) {
			auths.add(new SimpleGrantedAuthority(role.getRole()));
		}
		//        auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		User user = new User(foundUser.getLogin_id(),foundUser.getPasswd(),
				foundUser.isActive(), true, true, true, auths);

		return  user;


	}
}