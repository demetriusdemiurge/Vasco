package com.emperror1917.vasco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class VascoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VascoApplication.class, args);
    }

}
