package com.restcontrole.work.controler;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HEALTH {
    @GetMapping("/health-check")
    public String health(){
        return "Good";
    }

}
