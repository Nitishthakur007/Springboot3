package com.example.project.controller;

import com.example.project.Model.ApplicationUser;
import com.example.project.Model.Response;
import com.example.project.security.JwtUtil;
import com.example.project.service.ApplicationUserService;
import com.example.project.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody ApplicationUser theUser) {
        HttpStatus status = applicationUserService.registerUser(theUser);
        if (status == HttpStatus.OK) {
            return new ResponseEntity<>("message= " + "Registration successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("message= " + "Password or username policy failed", HttpStatus.BAD_REQUEST);
        }
    }

        @PostMapping("/signin")
        public ResponseEntity<Response> signInUser (@Valid @RequestBody ApplicationUser theUser){

        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(theUser.getUser_name(),theUser.getPassword()));

        }catch (UsernameNotFoundException e){
            return (ResponseEntity<Response>) ResponseEntity.notFound();
        }

           UserDetails userDetails =this.userAuthService.loadUserByUsername(theUser.getUser_name());
           String token = this.jwtUtil.generateToken(userDetails);
            return  ResponseEntity.ok(new Response("Authentication successful",token,userDetails.getUsername()));
        }



        @GetMapping("/viewprofile/{username}")
        public ApplicationUser viewUserProfile (@PathVariable String username){
            ApplicationUser theUser = this.applicationUserService.findById(username);
            return  theUser ;

        }

    }
