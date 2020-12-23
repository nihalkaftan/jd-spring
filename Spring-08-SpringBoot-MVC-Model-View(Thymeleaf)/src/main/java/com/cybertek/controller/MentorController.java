package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @GetMapping("/list")
    public String showTable(Model model){
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Nihal", "Kokuroglu", 25, Gender.FEMALE));
        mentorList.add(new Mentor("Erica", "Harris", 25, Gender.FEMALE));
        mentorList.add(new Mentor("Eric", "Harris", 21, Gender.MALE));

        model.addAttribute("mentors", mentorList);

        return "mentor/mentorList";
    }
}
