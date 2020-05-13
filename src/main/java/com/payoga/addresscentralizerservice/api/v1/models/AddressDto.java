package com.payoga.addresscentralizerservice.api.v1.models;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;

    private String street;

    private String city;

    private String state;

    private String country;

    private int zip;
}
