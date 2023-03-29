package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String returnPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
//        List<Post> posts = new ArrayList<>(Arrays.asList(
//                new Post(1, "Why I Love Java ", "Body text for post 1"),
//                new Post(2, "What is JSON?", "Body text for post 2"),
//                new Post(3, "ChatGPT is my girlfriend", "Body text for post 3")
//        ));
//
//        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnPost(@PathVariable Long id, Model model) {
        Post post = new Post(1, "Title test", "Body test");
        model.addAttribute("post", post);
        return "posts/show";
    }


}
