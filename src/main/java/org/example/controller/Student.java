package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class Student {
    @GetMapping
    public String sentToStudentPage(){
        return "student";
    }
    @GetMapping("/admin")
    public String sentToStudentAdminPage(){
        return "studentAdmin";
    }
}
