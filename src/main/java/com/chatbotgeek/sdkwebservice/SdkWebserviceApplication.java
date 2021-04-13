package com.chatbotgeek.sdkwebservice;

import com.chatbotgeek.sdkwebservice.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.chatbotgeek.sdkwebservice"})
public class SdkWebserviceApplication extends SpringBootServletInitializer {

    @Autowired
    static IService iService;

    public static void main(String[] args) {
        SpringApplication.run(SdkWebserviceApplication.class, args);
    }
}
