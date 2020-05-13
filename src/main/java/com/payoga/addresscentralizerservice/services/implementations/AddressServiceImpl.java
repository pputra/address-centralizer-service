package com.payoga.addresscentralizerservice.services.implementations;

import com.payoga.addresscentralizerservice.repositories.AddressRepository;
import com.payoga.addresscentralizerservice.services.interfaces.AddressService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
}
