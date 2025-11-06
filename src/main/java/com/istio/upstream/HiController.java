package com.istio.upstream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class HiController {
    Random random = new Random();

    @GetMapping("/hi")
    public ResponseEntity<String> hi() {
        if(random.nextBoolean()) {
            log.info("Custom internal error");
            return ResponseEntity.internalServerError().body("Custom internal error");
        }
        log.info("Success response from downstream");
        return ResponseEntity.ok("Hello from Service B");
    }
}
