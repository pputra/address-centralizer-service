package com.payoga.addresscentralizerservice.api.v1.mappers;

import com.payoga.addresscentralizerservice.api.v1.models.AddressDto;
import com.payoga.addresscentralizerservice.domains.Address;
import org.mapstruct.factory.Mappers;

public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto addressToAddressDto(Address address);

    Address addressDtoToAddress(AddressDto addressDto);
}
