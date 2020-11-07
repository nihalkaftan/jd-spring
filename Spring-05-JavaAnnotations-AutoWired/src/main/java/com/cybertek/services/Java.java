package com.cybertek.services;

import com.cybertek.interfaces.Courses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java implements Courses {

    private OfficeHours officeHours;

    /**
    @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
    */

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + officeHours.getHours()));
    }

}
