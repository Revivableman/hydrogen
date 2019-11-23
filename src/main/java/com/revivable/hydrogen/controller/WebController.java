package com.revivable.hydrogen.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web")
public class WebController {

    @RequestMapping("/{view}")
    public String html(@PathVariable("view") String view){
        System.out.println("enter jsp open controller");
        return view;
    }
}
