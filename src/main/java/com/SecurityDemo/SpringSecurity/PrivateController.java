package com.SecurityDemo.SpringSecurity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/private")
public class PrivateController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
                "message", "Hello from a private endpoint"

        );
    }



    @GetMapping("/secret")
    public Map<String, String> secret() {
        return Map.of(
                "secret", "only authenticated users can see this"
        );
    }
}
