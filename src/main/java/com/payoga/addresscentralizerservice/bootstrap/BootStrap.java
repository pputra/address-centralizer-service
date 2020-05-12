package com.payoga.addresscentralizerservice.bootstrap;

import com.payoga.addresscentralizerservice.domains.Customer;
import com.payoga.addresscentralizerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootStrap implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        seedCustomers();
    }

    private void seedCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("john_doe@mail.com");
        customer1.setPassword("foo");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Elon");
        customer2.setLastName("Musk");
        customer2.setEmail("elon_musk@mail.com");
        customer2.setPassword("foo");
        customerRepository.save(customer2);
    }
}
