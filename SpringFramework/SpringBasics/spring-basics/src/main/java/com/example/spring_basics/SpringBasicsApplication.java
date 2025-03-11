package com.example.spring_basics;

import com.example.spring_basics.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {


	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Desktop dt = context.getBean("hello", Desktop.class);
		dt.compile();

//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		SpringApplication.run(SpringBasicsApplication.class, args);
//
//		Alien obj1 = (Alien) context.getBean("alien");
//		System.out.println(obj1.getAge());
//		obj1.code();
	}

}
