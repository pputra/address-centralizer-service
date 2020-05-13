package com.payoga.addresscentralizerservice.services.implementations;

import com.payoga.addresscentralizerservice.api.v1.mappers.AddressMapper;
import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.SetActiveAddressRequest;
import com.payoga.addresscentralizerservice.domains.Address;
import com.payoga.addresscentralizerservice.domains.Customer;
import com.payoga.addresscentralizerservice.repositories.AddressRepository;
import com.payoga.addresscentralizerservice.repositories.CustomerRepository;
import com.payoga.addresscentralizerservice.services.interfaces.AddressService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    private final CustomerRepository customerRepository;

    private final AddressMapper addressMapper;

    @Override
    @Transactional
    public AddressDto setActiveAddress(SetActiveAddressRequest setActiveAddressRequest) {
        Optional<Address> updatedAddressOptional = addressRepository
                .findById(setActiveAddressRequest.getId());

        if (!updatedAddressOptional.isPresent()) {
            // TODO: throw an exception
        }

        Optional<Customer> customerOptional = customerRepository.findById(setActiveAddressRequest.getUid());

        if (!customerOptional.isPresent()) {
            // TODO: throw an exception
        }

        if (setActiveAddressRequest.isActiveVal()) {
            customerRepository.findById(setActiveAddressRequest.getUid())
                    .get().getAddresses().forEach((address -> address.setActive(false)));
        }

        Address updatedAddress = updatedAddressOptional.get();
        updatedAddress.setActive(setActiveAddressRequest.isActiveVal());

        return addressMapper.addressToAddressDto(updatedAddress);
    }
}
