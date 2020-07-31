package com.example.lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueTestController {

    @GetMapping("/vuetest")
    public String vueIndex() {
        return "vuetest/vueIndex";
    }

    @GetMapping("/vueAddFunction")
    public String vueAddFunction() {
        return "vuetest/vueAddFunction";
    }
}
