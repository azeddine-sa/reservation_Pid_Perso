package be.iccbxl.pid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "Gretting from Spring Boot!";
    }
}