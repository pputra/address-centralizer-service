package com.payoga.addresscentralizerservice.services.implementations;

import com.payoga.addresscentralizerservice.api.v1.mappers.AddressMapper;
import com.payoga.addresscentralizerservice.api.v1.mappers.CustomerMapper;
import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.api.v1.models.CustomerDto;
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

    public CustomerDto getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (!customerOptional.isPresent()) {
            // TODO: handle exception
        }

        Customer customer = customerOptional.get();
        CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
        List<AddressDto> addressDtoList = new ArrayList<>();
        customer.getAddresses()
                .forEach((address)->addressDtoList
                .add(addressMapper.addressToAddressDto(address)));
        customerDto.setAddresses(addressDtoList);

        return customerDto;
    }
}
