package com.nitish.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    //  expose a new endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: "+coachName +", Team: " + teamName;
    }

    // expose "/" that return "Hello world"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World from inside Rest controller";
    }


    //  expose a new endpoint for workout

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k !";
    }
}
