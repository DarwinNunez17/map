package com.laborator.FootballDatabase.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PrincipalController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
