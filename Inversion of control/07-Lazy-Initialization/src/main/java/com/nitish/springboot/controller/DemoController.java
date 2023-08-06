package com.nitish.springboot.controller;

import com.nitish.springboot.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public DemoController(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define a private field for the dependency
    private Coach myCoach;

    @Autowired
    public void DemoController(@Qualifier("cricketCoach") Coach theCoach){
        myCoach=theCoach;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "Welcome to home Page";
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}