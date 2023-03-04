package com.example.pets_shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class PetsShelterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetsShelterApplication.class, args);
    }

}
