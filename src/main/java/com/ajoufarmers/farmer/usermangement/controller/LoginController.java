package com.ajoufarmers.farmer.usermangement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login/oauth2/code/google")
    public String redirection(){
        return "Hello World!"; //Redirect url 반환
    }
}
