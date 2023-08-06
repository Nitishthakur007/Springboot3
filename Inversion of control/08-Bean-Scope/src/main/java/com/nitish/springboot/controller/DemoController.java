package com.nitish.springboot.controller;

import com.nitish.springboot.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public void DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In Constructor: " + getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "Welcome to home Page";
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comapring beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
