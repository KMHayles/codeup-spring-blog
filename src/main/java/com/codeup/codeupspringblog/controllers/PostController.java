package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {

         List<Post> posts = postDao.findAll();
//
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnPostById(@PathVariable Long id, Model model) {
        Post post = postDao.getAdById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createGET(Model model) {
        model.addAttribute("posts", new Post());
        return "posts/create";
    }

    @PostMapping("/posts")
    public String createPOST(@ModelAttribute Post post) {
        User user = userDao.findById(1);
        post.setUser(user);
        emailService.prepareAndSend("New Post","You created a new post");
        System.out.println("User created new post");
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostView(@PathVariable("id") Long id, Model model){
        Post editPost = postDao.findById(id).get();
        model.addAttribute("posts",editPost);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post, @PathVariable Long id) {
        Post editedPost = postDao.findById(id).get();
        editedPost.setTitle(post.getTitle());
        editedPost.setBody(post.getBody());
        postDao.save(editedPost);
        return "redirect:/posts";
    }



}
