package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("music")
public class MusicController {
    @GetMapping
    public String sentToMusicPage(){
        return "music";}
    @GetMapping("/admin")
    public String sentToMusicAdminPage(){
        return "musicAdmin";
    }
}
