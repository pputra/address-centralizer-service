package com.payoga.addresscentralizerservice.services.implementations;

import com.payoga.addresscentralizerservice.api.v1.mappers.AddressMapper;
import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.CreateAddressRequest;
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
    @Transactional(rollbackFor=Exception.class)
    public AddressDto createAddress(CreateAddressRequest createAddressRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(createAddressRequest.getUid());

        if (!customerOptional.isPresent()) {
            // TODO: throw an exception
        }

        Address newAddress = new Address();
        newAddress.setStreet(createAddressRequest.getStreet());
        newAddress.setCity(createAddressRequest.getCity());
        newAddress.setState(createAddressRequest.getState());
        newAddress.setCountry(createAddressRequest.getCountry());
        newAddress.setCustomer(customerOptional.get());

        addressRepository.save(newAddress);
        return addressMapper.addressToAddressDto(newAddress);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
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
