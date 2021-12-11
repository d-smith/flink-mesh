package org.ds.flink.h1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello1Controller {
    private final static Logger logger = LoggerFactory.getLogger(Hello1Controller.class);

    @GetMapping("/greeting")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Hello, one", HttpStatus.OK);
    }
}
