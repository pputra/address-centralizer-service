package com.payoga.addresscentralizerservice.api.v1.models;

import lombok.Data;

@Data
public class SetActiveAddressRequest {
    Long id;
    Long uid;
    boolean activeVal;
}
