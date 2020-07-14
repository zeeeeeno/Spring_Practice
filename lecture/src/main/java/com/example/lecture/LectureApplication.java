package com.example.lecture;

import com.example.lecture.nativeinterface.test.HelloSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring의 메인 애플리케이션이 될 것임을 의미
@SpringBootApplication
public class LectureApplication {
	final static Logger log =
			LoggerFactory.getLogger(LectureApplication.class);

	// SpringApplication.run 하면
	// 웹 서버가 구동된다 - 서비스 번호: 8080
	public static void main(String[] args) {
		// hs = HelloSpring() -->> 파이썬에서 생성자 생성
		HelloSpring hs = new HelloSpring();
		log.info(hs.print());

		SpringApplication.run(LectureApplication.class, args);
	}
}
