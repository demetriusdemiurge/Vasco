package com.emperror1917.vasco.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapWebController {
    
    @GetMapping
    public String map() {
        return "map";
    }
} 