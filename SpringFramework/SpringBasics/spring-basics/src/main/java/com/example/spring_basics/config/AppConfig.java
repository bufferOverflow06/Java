package com.example.spring_basics.config;

import com.example.spring_basics.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "hello")
    public Desktop desktop(){
        return new Desktop();
    }
}
