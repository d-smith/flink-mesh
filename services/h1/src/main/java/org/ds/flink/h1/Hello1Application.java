package org.ds.flink.h1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hello1Application {
    private final static Logger logger = LoggerFactory.getLogger(Hello1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Hello1Application.class, args);
    }
}