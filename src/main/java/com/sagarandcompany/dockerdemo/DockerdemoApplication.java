package com.sagarandcompany.dockerdemo;

import com.sagarandcompany.dockerdemo.beansscope.AddressProvider;
import com.sagarandcompany.dockerdemo.beansscope.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
//@ImportResource("classpath:beans.xml")
public class DockerdemoApplication extends SpringBootServletInitializer {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    public static void main(String[] args) {
//        ApplicationContext applicationContext = SpringApplication.run(DockerdemoApplication.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService1 = (UserService) applicationContext.getBean("userService1");
        System.out.println("------------------------------------------------");
        UserService userService2 = (UserService) applicationContext.getBean("userService2");

        UserService userService31 = (UserService) applicationContext.getBean("userService3");
        UserService userService32 = (UserService) applicationContext.getBean("userService3");
        UserService userService33 = (UserService) applicationContext.getBean("userService3");
//        UserService userService2 = (UserService) applicationContext.getBean("userService2");
        AddressProvider addressProvider = (AddressProvider) applicationContext.getBean("addressProvider");
        System.out.println(addressProvider.getAddress().toString());

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

