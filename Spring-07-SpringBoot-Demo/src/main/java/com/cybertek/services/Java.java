package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //private OfficeHours officeHours;

    @Value("${instructor}")
    private String instructorName;

    private ExtraSession extraSession;

    @Override
    public int getTeachingHours() {
        return 20 + extraSession.getHours();
    }

    @Autowired
    public Java(ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    //    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }
}
