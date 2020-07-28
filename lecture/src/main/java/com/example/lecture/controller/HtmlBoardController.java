package com.example.lecture.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class HtmlBoardController {
    private static final Logger logger =
            LoggerFactory.getLogger(HtmlBoardController.class);

    @GetMapping(value = "/get", params = "register")
    public String getRegister() {
        logger.info("getRegister()");

        return "register";
    }

    @GetMapping(value = "/get", params = "read")
    public String getRead() {
        logger.info("getRegister()");

        return "htmlRead";
    }

    @GetMapping("/html/register")
    public String registerForm(){
        logger.info("registerForm");

        return "htmlRegister";
    }

    @PostMapping("/html/register")
    public String register(){
        logger.info("register(POST)");

        return "htmlRegister";
    }

    @PostMapping("/html/modify")
    public String modify(){
        logger.info("register(POST)");

        return "htmlModifyForm";
    }

    @GetMapping("/html/modify")
    public String modifyForm(){
        logger.info("modifyForm()");

        return "htmlModifyForm";
    }

    @GetMapping("/html/delete")
    public String deleteForm(){
        logger.info("deleteForm()");

        return "htmlDeleteForm";
    }

    @PostMapping("/html/delete")
    public String delete(){
        logger.info("register(POST)");

        return "htmlDeleteForm";
    }

    @GetMapping(value = "/html/list")
    public String listForm(){
        logger.info("listForm()");

        return "htmlListForm";
    }

    // 모든 게시판에는 게시판 번호가 있다.
    // PathVariable을 통해서 가변 번호를 받을 수 있게 만든다.
    @GetMapping("/html/board/{boardNo}")
    public String readForm(@PathVariable("boardNo") int boardNo) {
        logger.info("readForm: " + boardNo);

        return "htmlRead";
    }

    @PostMapping("/regtest")
    public String registerTest(String userID, String passwd){
        logger.info("registerTest");
        logger.info("userID = "+userID);
        logger.info("passwd = "+passwd);

        return "form/success";
    }

    @GetMapping("/regtestpage")
    public String registerTestPage() {
        logger.info("registerTestPage()");

        return "form/registerForm";
    }

    @GetMapping("/getRegTest")
    public String getRegTest(String userId, Date date) {
        logger.info("getRegTest()");
        logger.info("UserID = "+userId);
        logger.info("date = "+date);

        return "form/success";
    }

}

// MusicController를 하나 만든다.
// Controller 기능으로는 음악 재생, 메뉴 보기, 녹음
// 이와 관련된 html controller 구성을 직접 해보