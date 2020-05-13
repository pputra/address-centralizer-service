package com.payoga.addresscentralizerservice.controllers.v1;

import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.SetActiveAddressRequest;
import com.payoga.addresscentralizerservice.services.interfaces.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(AddressController.BASE_URL)
@AllArgsConstructor
public class AddressController {
    public static final String BASE_URL = "/api/v1/address";

    private final AddressService addressService;

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> setActiveAddress(@RequestBody SetActiveAddressRequest setActiveAddressRequest) {
        AddressDto addressDto = addressService.setActiveAddress(setActiveAddressRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "address active status has been updated");
        response.put("data", addressDto);

        return response;
    }
}
