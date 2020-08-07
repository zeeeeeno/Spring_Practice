package com.example.lecture.controller;

import com.example.lecture.entity.RandNumMessage;
import com.example.lecture.service.RandNumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RandomNumController {
    static final Logger log = LoggerFactory.getLogger(RandomNumController.class);

    @Autowired
    private RandNumService randNumService;

    public RandomNumController(RandNumService randNumService) {
        this.randNumService = randNumService;
    }

    /* ResponseEntity: json 객체를 리턴으로 사용 */
    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("Controller: getRandom()");
        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);
    }
}
