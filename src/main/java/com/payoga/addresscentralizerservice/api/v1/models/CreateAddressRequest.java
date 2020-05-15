package com.payoga.addresscentralizerservice.api.v1.models;

import lombok.Data;

@Data
public class CreateAddressRequest {
    private Long uid;

    private String street;

    private String city;

    private String state;

    private String country;

    private int zip;
}
