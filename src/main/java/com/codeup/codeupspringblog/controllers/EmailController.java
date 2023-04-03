package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }




}
