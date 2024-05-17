package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/test")
    public String test(){
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
