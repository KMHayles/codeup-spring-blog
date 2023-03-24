package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String returnAboutPage(){
        return "about";
    }


}
