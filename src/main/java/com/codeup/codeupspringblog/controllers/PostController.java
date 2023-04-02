package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String returnPosts(Model model) {

         List<Post> posts = postDao.findAll();
//
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnPost(@PathVariable Long id, Model model) {
        Post post = postDao.getAdById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createTheProduct() {
        return "/posts/create";
    }

    @PostMapping("/posts")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        User user = userDao.findById(1);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }


}
