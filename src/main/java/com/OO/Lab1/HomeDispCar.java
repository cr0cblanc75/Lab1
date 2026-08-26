package com.OO.Lab1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeDispCar {

    @GetMapping("/")
    public String hello() {        
        return "redirect:/cars";
    }
}
