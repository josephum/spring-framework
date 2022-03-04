package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name","Jose");
        model.addAttribute("course","MVC");
        model.addAttribute("time", LocalTime.now());

        // create some random studentId(0-1000) and show it in your UI
        model.addAttribute("studentId", new Random().nextInt(1000));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(100);
        model.addAttribute("numbers", numbers);


        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);


        return "student/welcome";
    }

}
