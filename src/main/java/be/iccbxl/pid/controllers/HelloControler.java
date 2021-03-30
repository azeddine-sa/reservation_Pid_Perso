package be.iccbxl.pid.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloControler {

    @GetMapping("/")
    public String index(){
        return "Gretting from Spring Boot!";
    }
}

