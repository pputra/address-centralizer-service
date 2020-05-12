package com.payoga.addresscentralizerservice.repositories;

import com.payoga.addresscentralizerservice.domains.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
