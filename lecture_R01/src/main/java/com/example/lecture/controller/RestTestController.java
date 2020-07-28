package com.example.lecture.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 어떤 데이터든 json 방식으로 처리
@RestController
public class RestTestController {

    @RequestMapping("/test")
    public String test() {
        return "Spring Test Check";
    }

}
