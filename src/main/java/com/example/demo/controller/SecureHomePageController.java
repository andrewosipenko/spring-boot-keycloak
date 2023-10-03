package com.example.demo.controller;

import com.example.demo.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(WebConstants.URLs.SECURE_PORTAL)
public class SecureHomePageController {
    @GetMapping
    public String getSecureHomePage(){
        return "pages/secure-home";
    }
}
