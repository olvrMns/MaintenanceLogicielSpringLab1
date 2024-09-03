package edu.mv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RocketController {

    @GetMapping("/superRocket")
    public String superRocket() {
        return "Super Rocket!";
    }
}
