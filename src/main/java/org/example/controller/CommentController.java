package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comment")
public class CommentController {
    @GetMapping
    public String sentToCommentPage(){
        return "comment";
    }
}
