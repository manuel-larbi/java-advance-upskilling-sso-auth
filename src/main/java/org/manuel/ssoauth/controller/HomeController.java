package org.manuel.ssoauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("secured")
    public String secured(){
        return "secured";
    }

    @GetMapping("logged-in-user-details")
    public Principal loggedInUserDetails(Principal principal){
        return principal;
    }
}
