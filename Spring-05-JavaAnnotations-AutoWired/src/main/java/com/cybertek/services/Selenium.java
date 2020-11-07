package com.cybertek.services;

import com.cybertek.interfaces.Courses;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Courses {
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 15");
    }
}
