package com.cybertek.services;

import com.cybertek.interfaces.Courses;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Courses {

    @Autowired
    @Qualifier("officeHours")
    private ExtraSessions extraSessions;

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (20 + extraSessions.getHours()));
    }

}
