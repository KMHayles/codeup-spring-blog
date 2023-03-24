package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@Controller
public class FirstController {

//    @PostMapping("/pizza-order")
//    public String placeOrder(@RequestParam String crust, )



    @GetMapping("/hello")
    @ResponseBody
    public String returnHelloWorld() {
        return "Hello Zenith";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String greetName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/kenneth")
    @ResponseBody
    public String returnKenneth(){
        return "<h2>Ken</h2>";
    }



}
