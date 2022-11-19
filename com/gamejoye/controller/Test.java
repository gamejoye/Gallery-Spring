package com.gamejoye.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("test")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true",maxAge = 3600)
@Controller
public class Test {
    @RequestMapping(value = "t1")
    @ResponseBody
    public String test() {
        return "test";
    }
}
