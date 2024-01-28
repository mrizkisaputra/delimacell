package com.mrizkisaputra.auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping(path = "/login")
    public String loginView() {
        return "login";
    }

    @GetMapping(path = "/")
    public String domain() {
        return "home";
    }

    @GetMapping(path = "/home")
    public String homeView() {
        return "home";
    }

}
