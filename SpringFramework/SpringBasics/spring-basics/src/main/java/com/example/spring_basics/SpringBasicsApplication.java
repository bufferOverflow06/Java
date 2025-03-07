package com.example.spring_basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		SpringApplication.run(SpringBasicsApplication.class, args);

		Alien obj = (Alien) context.getBean("alien");
		obj.code();
	}

}
