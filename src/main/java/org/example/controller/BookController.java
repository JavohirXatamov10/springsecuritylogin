package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
public class BookController {
    @GetMapping
    public String sentToBookPage(){
        return "book";
    }
    @GetMapping("/admin")
    public String sentToBookAdminPage(){
        return "bookAdmin";
    }
}
