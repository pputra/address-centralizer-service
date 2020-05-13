package com.payoga.addresscentralizerservice.api.v1.models;

import lombok.Data;

import java.util.List;

@Data
public class AddressListDto {
    private List<AddressDto> addresses;
}
