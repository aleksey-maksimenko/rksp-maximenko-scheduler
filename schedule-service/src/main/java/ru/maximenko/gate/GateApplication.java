package ru.maximenko.gate;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients(basePackages = "ru.maximenko.scheduler.client.api")
@EnableScheduling
public class GateApplication {

    public static void main(String[] args) {

        SpringApplication.run(GateApplication.class, args);
        System.out.println("ok");
    }

}
