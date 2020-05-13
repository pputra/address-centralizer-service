package com.payoga.addresscentralizerservice.services.implementations;

import com.payoga.addresscentralizerservice.api.v1.mappers.AddressMapper;
import com.payoga.addresscentralizerservice.api.v1.mappers.CustomerMapper;
import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.CustomerDto;
import com.payoga.addresscentralizerservice.domains.Address;
import com.payoga.addresscentralizerservice.domains.Customer;
import com.payoga.addresscentralizerservice.repositories.CustomerRepository;
import com.payoga.addresscentralizerservice.services.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressMapper addressMapper;

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (!customerOptional.isPresent()) {
            // TODO: throw an exception
        }

        return customerOptional.get();
    }

    @Override
    public CustomerDto getCustomerInfoDtoWithAddressesById(Long id) {
        Customer customer = getCustomerById(id);
        CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
        List<AddressDto> addressDtoList = new ArrayList<>();
        customer.getAddresses()
                .forEach((address)->addressDtoList
                .add(addressMapper.addressToAddressDto(address)));
        customerDto.setAddresses(addressDtoList);

        return customerDto;
    }

    @Override
    public CustomerDto getCustomerInfoDtoWithActiveAddressById(Long id) {
        Customer customer = getCustomerById(id);
        CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
        List<AddressDto> addressDtoList = new ArrayList<>();

        for (Address address : customer.getAddresses()) {
            if (address.isActive()) {
                addressDtoList.add(addressMapper.addressToAddressDto(address));
                break;
            }
        }

        customerDto.setAddresses(addressDtoList);

        return customerDto;
    }
}
