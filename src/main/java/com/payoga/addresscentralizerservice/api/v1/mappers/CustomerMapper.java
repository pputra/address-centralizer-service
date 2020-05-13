package com.payoga.addresscentralizerservice.api.v1.mappers;

import com.payoga.addresscentralizerservice.api.v1.models.CustomerDto;
import com.payoga.addresscentralizerservice.domains.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
