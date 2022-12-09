package com.gosha.universityproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityProjectApplication.class, args);
        long start = System.currentTimeMillis();
        long end = start + 1000 * 60 * 5;
        while (true) {
            if (System.currentTimeMillis() >= end) {
                System.exit(0);
            }
        }
    }

}
