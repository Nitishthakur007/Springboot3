package com.example.project.service;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;



@Service
public class UserAuthService implements UserDetailsService {


    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ApplicationUserService applicationUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ApplicationUser theUser = this.applicationUserService.findById(userName);
        return new User(theUser.getUser_name(),theUser.getPassword(),new ArrayList<>());
    }
}
