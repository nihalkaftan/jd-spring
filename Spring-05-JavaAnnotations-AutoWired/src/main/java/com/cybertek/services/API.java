package com.cybertek.services;

import com.cybertek.interfaces.Courses;
import org.springframework.stereotype.Component;

@Component
public class API implements Courses {
    @Override
    public void getTeachingHours() {
        System.out.println("API teaching hours are 30 hours");
    }
}
