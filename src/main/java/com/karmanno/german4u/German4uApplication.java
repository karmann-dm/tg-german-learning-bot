package com.karmanno.german4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class German4uApplication {

    public static void main(String[] args) {
        SpringApplication.run(German4uApplication.class, args);
    }
}
