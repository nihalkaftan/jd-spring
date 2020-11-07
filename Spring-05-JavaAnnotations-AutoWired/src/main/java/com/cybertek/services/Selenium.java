package com.cybertek.services;

import com.cybertek.interfaces.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Courses {

    private OfficeHours officeHours;

    @Autowired
    public void setOfficeHours(OfficeHours officeHours){
        this.officeHours = officeHours;
    }

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (15 + officeHours.getHours()));
    }
}
