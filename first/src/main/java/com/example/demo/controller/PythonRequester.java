package com.example.demo.controller;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PythonRequester {
    final static Logger log =
            LoggerFactory.getLogger(PythonRequester.class);

    @RequestMapping(
            value = "/image",
            method = RequestMethod.GET,
            produces = "image/jpg"
    )
    public @ResponseBody byte[] getFile()  {
        try {
            // Retrieve image from the classpath.
            InputStream is = this.getClass().getResourceAsStream("http://127.0.0.1:5000/");

            // Prepare buffered image.
            BufferedImage img = ImageIO.read(is);

            // Create a byte array output stream.
            ByteArrayOutputStream bao = new ByteArrayOutputStream();

            // Write to output stream
            ImageIO.write(img, "jpg", bao);

            return bao.toByteArray();
        } catch (IOException e) {
            log.error(String.valueOf(e));
            throw new RuntimeException(e);
        }
    }

//    /*
//    RequestMapping value는 결국 URL 주소에 해당한다.
//    그러므로 localhost:8080/doRequestPythonRest 이것이 URL 요청으로 들어가면 아래 함수가 동작한다.
//     */
//    @RequestMapping(
//            value = "/doRequestPythonRest",
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            method = RequestMethod.GET
//    )
//    public String doRequestPythonRest() {
//        log.info("doRequestPythonRest()");
//
//        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
//        converters.add(new FormHttpMessageConverter());
//        converters.add(new StringHttpMessageConverter());
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setMessageConverters(converters);
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//        map.add("str", "request test");
//
//        /*
//        Python Flask 서버의 5000번에 dataServer URL을 요청하는 작업
//         */
//        String result = restTemplate.getForObject(
//                "http://localhost:5000/",
//                String.class
//        );
//
//        log.info("result = " + result);
//
//        return result;
//
//    }
}