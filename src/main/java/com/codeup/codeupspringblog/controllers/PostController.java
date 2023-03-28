package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String returnPosts(Model model) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("Why I Love ", "Body 1"),
                new Post("Title 2", "Body 2"),
                new Post("Title 3", "Body 3")
        ));
        
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnPost(@PathVariable Long id, Model model) {
        Post post = new Post("Title test", "Body test");
        model.addAttribute("post", post);
        return "posts/show";
    }


}
