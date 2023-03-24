package com.codeup.codeupspringblog.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String returnPosts(){
        return "Viewing Posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String returnPost(@PathVariable Long id){
        return "Viewing Post with id of " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String returnPostCreateForm() {
        return "Viewing post create form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Creating post....";
    }



}
