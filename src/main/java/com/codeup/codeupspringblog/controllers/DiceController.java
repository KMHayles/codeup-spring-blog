package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollTheDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollResult(@PathVariable int guess, Model model) {
        int roll = new Random().nextInt(6) + 1;

        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);

        return "roll-result";
    }




}
