package com.github.robertomanfreda.poc.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/protected/prova")
    public String prova() {
        return "Hello, USER or ADMIN!";
    }
}
