package br.mil.defesa.interc2.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello World public";
    }

    @GetMapping("/private/hello")
    public String privateHello() {
        return "Hello World private";
    }

}
