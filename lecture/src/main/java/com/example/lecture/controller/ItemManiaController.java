package com.example.lecture.controller;

import com.example.lecture.entity.GameMania;
import com.example.lecture.service.ItemManiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemManiaController {
    private static final Logger log =
            LoggerFactory.getLogger(ItemManiaController.class);

    @Autowired
    private ItemManiaService service;

    @GetMapping("/getItemRegister")
    public String getRegister(GameMania gameMania, Model model) throws Exception {
        log.info("getRegister()");

        return "gameMania/register";
    }

    @PostMapping("/postItemRegister")
    public String postRegister(GameMania gameMania, Model model) throws Exception {
        log.info("postRegister()");

        service.register(gameMania);

        model.addAttribute(
                "msg", "Register Success"
        );

        return "gameMania/success";
    }

    @GetMapping("/itemList")
    public String list(Model model) throws Exception {
        log.info("list()");
        model.addAttribute("list", service.list());

        return "gameMania/itemList";
    }


    @GetMapping("/itemRead")
    public String read(int id, Model model) throws Exception {
        log.info("read()");
        model.addAttribute(service.read(id));

        return "gameMania/read";
    }

    @PostMapping("/itemRemove")
    public String remove(int id, Model model) throws Exception {
        log.info("remove()");

        service.remove(id);
        model.addAttribute("msg", "Success Delete!");

        return "gameMania/success";
    }

    @GetMapping("/getItemModify")
    public String modify(int id, Model model) throws Exception {
        log.info("getModify()");

        model.addAttribute(service.read(id));

        return "gameMania/modify";
    }

    @PostMapping("/postItemModify")
    public String modify(GameMania gameMania, Model model) throws Exception {
        log.info("postModify()");
        model.addAttribute("msg", "Success Modify");
        service.modify(gameMania);

        return "gameMania/success";
    }}

