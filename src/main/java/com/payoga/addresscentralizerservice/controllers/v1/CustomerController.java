package com.payoga.addresscentralizerservice.controllers.v1;

import com.payoga.addresscentralizerservice.services.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(CustomerController.BASE_URL)
@AllArgsConstructor
public class CustomerController {
    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getCustomerInfo(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "customer info has been fetched");
        response.put("data", customerService.getCustomerInfoDtoWithAddressesById(id));

        return response;
    }

    @GetMapping({"/{id}/active"})
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getCustomerInfoWithActiveAddress(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "customer info with an active address has been fetched");
        response.put("data", customerService.getCustomerInfoDtoWithActiveAddressById(id));

        return response;
    }
}
