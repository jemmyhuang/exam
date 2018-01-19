package com.example.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ExamApplication.class);
        application.setWebEnvironment(true);
        application.run(args);
    }
}
