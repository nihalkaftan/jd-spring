package com.cybertek;

import com.cybertek.interfaces.Courses;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Courses course = container.getBean("java", Courses.class);

        course.getTeachingHours();


    }
}
