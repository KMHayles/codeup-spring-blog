package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.config.SecurityConfiguration;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.UserDetailsLoader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userDao;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsLoader usersLoader;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, UserDetailsLoader usersLoader)  {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.usersLoader = usersLoader;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        System.out.println(hash);
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/user/{id}/posts")
    public String userAds(@PathVariable long id, Model model){
        User user = userDao.findById(1);
        List<Post> userPosts = user.getPosts();
        model.addAttribute("userPosts", userPosts);
        return "/posts/show";

    }

}
