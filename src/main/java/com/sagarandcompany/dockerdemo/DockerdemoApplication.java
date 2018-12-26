package com.sagarandcompany.dockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerdemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DockerdemoApplication.class, args);
    }
//
//    @Bean
//    public EmployeeService employeeService() {
//        return new EmployeeService();
//    }
}

