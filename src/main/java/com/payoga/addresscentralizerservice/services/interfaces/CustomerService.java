package com.payoga.addresscentralizerservice.services.interfaces;

import com.payoga.addresscentralizerservice.api.v1.models.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(Long id);
}
