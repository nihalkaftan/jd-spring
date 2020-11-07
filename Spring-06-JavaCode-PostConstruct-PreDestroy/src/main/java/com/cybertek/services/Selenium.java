package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Selenium implements Course {
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours 20");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Executing post construct");
    }
}
