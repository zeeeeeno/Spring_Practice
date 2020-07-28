package com.example.lecture.controller;

import com.example.lecture.entity.Music;
import com.sun.net.httpserver.Headers;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
@Controller를 사용할 경우 HTML 핸들링에 특화되어 있으므로 데이터를 처리하고자 할 경우
ResponseEntity를 활용해야 한다.

@RestController는 json 형식으로 데이터 처리에 특화되어 있으므로 HTML을 처리하고자 할 경우
ModelView를 활용해야 한다.
 */
// @RestController - 모델 & 뷰가 필요(html 핸들링)
// @RestController - default로 json 타입 리턴, 데이터 핸들링
@RestController
@RequestMapping("musics")
public class MusicController {
    private static final Logger logger = LoggerFactory.getLogger(MusicController.class);

    @GetMapping("")
    public ModelAndView musicIndex() {
        logger.info("musicIndex()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicIndex");

        return modelAndView;
    }

    @GetMapping("/test")
    public Music musicTest() {
        logger.info("musicTest()");

        Music music = new Music();

        return music;
    }

    @GetMapping("/play")
    public ModelAndView musicPlay() {
        logger.info("musicPlay()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicPlay");

        return modelAndView;
    }

    @GetMapping("/menu")
    public ModelAndView musicMenu() {
        logger.info("musicMenu()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicMenu");

        return modelAndView;
    }

    @GetMapping("/record")
    public ModelAndView musicRecord() {
        logger.info("musicRecord()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicRecord");

        return modelAndView;
    }

    @GetMapping("/titles")
    public List<Music> musicTitles() {
        logger.info("musicTitles()");
        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return list;
    }

    @GetMapping("/artists")
    public Map<String, Music> musicArtist() {
        logger.info("musicArtist()");

        Map<String, Music> map = new HashMap<String, Music>();
        Music music1 = new Music();
        map.put("artists1", music1);

        Music music2 = new Music();
        map.put("artists2", music2);

        return map;
    }

    // ResponseEntity<Void> : JSON 파일 처리
    @GetMapping("/resptest")
    public ResponseEntity<Void> musicRespTest() {
        logger.info("musicRespTest()");


        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/respstring")
    public ResponseEntity<String> musicRespString() {
        logger.info("musicRespString()");

        return new ResponseEntity<String>("Success!", HttpStatus.OK);
    }

    @GetMapping("/respclass")
    public ResponseEntity<Music> musicRespClass() {
        logger.info("musicRespClass()");

        Music music = new Music();

        return new ResponseEntity<Music>(music, HttpStatus.OK);
    }

    @GetMapping("/resplist")
    public ResponseEntity<List<Music>> musciRespList() {
        logger.info("musciRespList()");
        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return new ResponseEntity<List<Music>>(list, HttpStatus.OK);
    }

    @GetMapping("/respfile")
    public ResponseEntity<byte[]> musicImgFile() throws Exception {
        logger.info("musicImgFile()");

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream("/home/bitai/proj/Python_Practice/test_image_2.jpg");
            headers.setContentType(MediaType.IMAGE_JPEG);

            entity = new ResponseEntity<byte[]>(
                    IOUtils.toByteArray(in),
                    headers,
                    HttpStatus.CREATED
            );

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);

        } finally {
            in.close();
        }

        return entity;
    }

}
