package com.sagarandcompany.dockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerdemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DockerdemoApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder
                                                         application) {
        return application.sources(DockerdemoApplication.class);
    }
//
//    @Bean
//    public EmployeeService employeeService() {
//        return new EmployeeService();
//    }
}

