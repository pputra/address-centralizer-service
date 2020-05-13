package com.payoga.addresscentralizerservice.services.interfaces;

import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.SetActiveAddressRequest;

public interface AddressService {
    AddressDto setActiveAddress(SetActiveAddressRequest setActiveAddressRequest);
}
