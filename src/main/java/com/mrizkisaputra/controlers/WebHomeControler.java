package com.mrizkisaputra.controlers;

import com.mrizkisaputra.auth.services.ApplicationUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebHomeControler {
    @Autowired
    ApplicationUserService userService;
    @GetMapping(path = "/")
    public String domain() {
        return "home";
    }
    @GetMapping(path = "/home")
    public String homeView(Authentication user, Model model) {
        String role = userService.findRoleNameByUsername(user.getName());
        model.addAttribute("loggedInAs", role);
        return "home";
    }
}
