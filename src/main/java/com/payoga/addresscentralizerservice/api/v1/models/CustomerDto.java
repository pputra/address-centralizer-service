package com.payoga.addresscentralizerservice.api.v1.models;

import lombok.Data;

@Data
public class CustomerDto {
    private Long uid;

    private String firstName;

    private String lastName;

    private String email;

    private AddressListDto addressListDTO;
}
