package com.payoga.addresscentralizerservice.services.interfaces;

import com.payoga.addresscentralizerservice.api.v1.models.CustomerDto;
import com.payoga.addresscentralizerservice.domains.Customer;

public interface CustomerService {
    Customer getCustomerById(Long id);

    CustomerDto getCustomerInfoDtoWithAddressesById(Long id);

    CustomerDto getCustomerInfoDtoWithActiveAddressById(Long Id);
}
