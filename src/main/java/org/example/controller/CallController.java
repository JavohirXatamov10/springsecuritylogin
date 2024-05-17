package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/call")
public class CallController {
    @GetMapping
    public String sentToCallPage(){
        return "call";
    }
}
