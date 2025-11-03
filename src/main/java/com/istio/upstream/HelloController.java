package com.istio.upstream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Inside upstream service");
        String response = restTemplate.getForObject("http://downstream/hi", String.class);
        return "Service A says: "+ response ;
    }
}
