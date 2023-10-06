package com.example.project.service;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ApplicationUserService {

    private ApplicationUserRepository appUserRepo;


    @Autowired
    public ApplicationUserService(ApplicationUserRepository theUserRepo){
        appUserRepo = theUserRepo;
    }

    public HttpStatus registerUser(ApplicationUser theUser) {
        appUserRepo.save(theUser);
        return HttpStatus.OK;
    }


    public ApplicationUser findById(String userName) {
        Optional<ApplicationUser> result = appUserRepo.findById(userName);
        ApplicationUser theUser = null;

        if(result.isPresent()){
            theUser = result.get();
        }else {
            throw new RuntimeException("Did not find user with name - "+userName);
        }
        return theUser;
    }

}