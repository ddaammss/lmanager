package com.dchans.api;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class LmanagerApplication {

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println("TimeZone set to: " + TimeZone.getDefault().getID());
    }

    public static void main(String[] args) {
        SpringApplication.run(LmanagerApplication.class, args);
    }

}
