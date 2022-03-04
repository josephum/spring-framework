package com.cydeo.controller;

import com.cydeo.model.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {

    @RequestMapping("/list")
    public String showMentor(Model model){

        List<Mentor> mentorList2 = new ArrayList<>();

        mentorList2.add(new Mentor("Mike","Smith",33, Gender.MALE));
        mentorList2.add(new Mentor("Tom","Hanks",65, Gender.MALE));
        mentorList2.add(new Mentor("Ammy","Bryan",25, Gender.FEMALE));

        model.addAttribute("mentors",mentorList2);

        return "mentor/mentor-list";

    }
}
