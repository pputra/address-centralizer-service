package com.payoga.addresscentralizerservice.repositories;

import com.payoga.addresscentralizerservice.domains.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer, Long> {
}
