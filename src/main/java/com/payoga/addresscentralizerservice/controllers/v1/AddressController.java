package com.payoga.addresscentralizerservice.controllers.v1;

import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.CreateAddressRequest;
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

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> addAddress(CreateAddressRequest createAddressRequest) {
        AddressDto address = addressService.createAddress(createAddressRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "new address has been added");
        response.put("data", address);

        return response;
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> setActiveAddress(SetActiveAddressRequest setActiveAddressRequest) {
        AddressDto addressDto = addressService.setActiveAddress(setActiveAddressRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "address active status has been updated");
        response.put("data", addressDto);

        return response;
    }
}
