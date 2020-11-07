package com.cybertek.services;

import com.cybertek.interfaces.Courses;
import org.springframework.stereotype.Component;

@Component
public class Java implements Courses {

    private OfficeHours officeHours;

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + officeHours.getHours()));
    }

}
