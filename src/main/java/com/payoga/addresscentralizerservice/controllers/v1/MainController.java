package com.payoga.addresscentralizerservice.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@ResponseStatus(HttpStatus.OK)
public class MainController {
    @GetMapping
    @ResponseBody
    public Map<String, String> main() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "address-centralizer-service-v1");
        return response;
    }
}
