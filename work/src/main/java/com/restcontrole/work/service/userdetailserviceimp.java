package com.restcontrole.work.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.restcontrole.work.repository.userrepository;
import com.restcontrole.work.entries.user;
public class userdetailserviceimp implements UserDetailsService{

@Autowired
private userrepository userepo;


@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

    user user=userepo.findByusername(username);
if(user!=null){
    UserDetails userDetails=org.springframework.security.core.userdetails.User.builder()
    .username(user.getUsername())
    .password(user.getPassword())
    .roles(user.getRoles().toArray(new String[0]))
    .build();
    return userDetails;
}
   throw new UsernameNotFoundException("user not found with username"+username);
} 
}
