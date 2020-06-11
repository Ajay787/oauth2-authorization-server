package com.example.demo.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Role;
import com.example.demo.service.UserService;

@Configuration
//@Component
@Service("userDetailsService")
public class MyUserDetailsServiceImplemenation implements UserDetailsService{

//    @Autowired
//    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        com.example.demo.bean.User foundUser = userService.getUserByLoginId(username);
    	com.example.demo.bean.User foundUser = new com.example.demo.bean.User();
    	

//        if(foundUser==null){
//
//            throw new UsernameNotFoundException("User"+username+"can not be found");
//        }

        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
//        for(Role role:foundUser.getRoles()) {
//        	auths.add(new SimpleGrantedAuthority(role.getRole()));
//        }
        auths.add(new SimpleGrantedAuthority("admin"));
        
//        User user = new User(foundUser.getLogin_id(),foundUser.getPasswd(),
//        		foundUser.isActive(), true, true, true, auths);
        User user = new User("ajay",passwordEncoder.encode("test123"),
        		true, true, true, true, auths);

        return  user;


    }
}