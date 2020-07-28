package com.example.lecture.controller;

import com.example.lecture.entity.Board;
import com.example.lecture.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("/getRegister")
    public String getRegister(Board board, Model model) throws Exception {
        log.info("getRegister()");

        return "board/register";
    }

    @PostMapping("/postRegister")
    public String postRegister(Board board, Model model) throws Exception {
        log.info("postRegister()");

        service.register(board);

        model.addAttribute(
                "msg", "Register Success"
        );

        return "board/success";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list()");

        // 속성 추가 (이름: list)
        // Controller -> Service -> Repository 방식으로 동작
        // DB에서 읽어온 정보
        model.addAttribute("list", service.list());

        // html 파일 읽기
        return "board/list";
    }

    @GetMapping("/read")
    public String read(int boardNo, Model model) throws Exception {
        log.info("read()");
        model.addAttribute(service.read(boardNo));

        return "board/read";
    }

    @PostMapping("/remove")
    public String remove(int boardNo, Model model) throws Exception {
        log.info("remove()");

        service.remove(boardNo);
        model.addAttribute("msg", "Success Delete!");

        return "board/success";
    }

    @GetMapping("/getModify")
    public String modify(int boardNo, Model model) throws Exception {
        log.info("getModify()");

        model.addAttribute(service.read(boardNo));

        return "board/modify";
    }

    @PostMapping("/postModify")
    public String modify(Board board, Model model) throws Exception {
        log.info("postModify()");
        model.addAttribute("msg", "Success Modify");
        service.modify(board);

        return "board/success";
    }
}
