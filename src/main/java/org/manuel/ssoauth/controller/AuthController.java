package org.manuel.ssoauth.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final HttpServletRequest request;
    private final Environment environment;
    @GetMapping
    String login(){
        // get the base url from the request
        String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        System.out.println("Used port: " + environment.getProperty("local.server.port"));
        return "base url: " + baseUrl;
    }
}
