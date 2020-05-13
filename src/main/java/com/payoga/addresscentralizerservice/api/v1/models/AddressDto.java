package com.payoga.addresscentralizerservice.api.v1.models;

import com.payoga.addresscentralizerservice.domains.Customer;
import lombok.Data;

@Data
public class AddressDto {
    private Long id;

    private String street;

    private String city;

    private String state;

    private String country;

    private int zip;

    private Customer customer;
}
