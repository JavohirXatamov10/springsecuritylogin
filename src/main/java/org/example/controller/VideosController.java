package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("video")
public class VideosController {
    @GetMapping
    public String sentToVideoPage(){
        return "video";
    }
    @GetMapping("/admin")
    public String sentToVideoAdminPage(){
        return "videoAdmin";
    }
}
