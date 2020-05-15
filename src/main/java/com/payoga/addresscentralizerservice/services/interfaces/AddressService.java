package com.payoga.addresscentralizerservice.services.interfaces;

import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.CreateAddressRequest;
import com.payoga.addresscentralizerservice.api.v1.models.SetActiveAddressRequest;

public interface AddressService {
    AddressDto createAddress(CreateAddressRequest createAddressRequest);
    AddressDto setActiveAddress(SetActiveAddressRequest setActiveAddressRequest);
}
