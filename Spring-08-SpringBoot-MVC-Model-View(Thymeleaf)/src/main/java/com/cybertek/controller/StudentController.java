package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String StudentController(Model model){
        model.addAttribute("name","Nihal");
        model.addAttribute("course","MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        //crete some random student id (0-1000) and show it in your UI
        int id = new Random().nextInt(1000);
        model.addAttribute("id", id);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(9);
        numbers.add(12);

        model.addAttribute("numbers", numbers);

        //print your birthday
        LocalDate birthday = LocalDate.now().minusYears(25);
        model.addAttribute("birthday", birthday);

        Student student = new Student(1, "Nihal", "Kokuroglu");
        model.addAttribute("student", student);

        return "student/welcome";
    }

    @GetMapping("/register")
    public String homePage2(){
        return "student/register";
    }

}
