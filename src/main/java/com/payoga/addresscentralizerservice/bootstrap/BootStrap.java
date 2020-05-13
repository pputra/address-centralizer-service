package com.payoga.addresscentralizerservice.bootstrap;

import com.payoga.addresscentralizerservice.domains.Address;
import com.payoga.addresscentralizerservice.domains.Customer;
import com.payoga.addresscentralizerservice.repositories.AddressRepository;
import com.payoga.addresscentralizerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootStrap implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

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
        Address address1 = new Address();
        address1.setStreet("some street");
        address1.setCity("Malibu");
        address1.setState("CA");
        address1.setCountry("USA");
        address1.setZip(90265);
        address1.setActive(true);
        address1.setCustomer(customer1);
        addressRepository.save(address1);
        Address address2 = new Address();
        address2.setStreet("other street");
        address2.setCity("Hidden Hills");
        address2.setState("CA");
        address2.setCountry("USA");
        address2.setZip(91302);
        address2.setCustomer(customer1);
        addressRepository.save(address2);


        Customer customer2 = new Customer();
        customer2.setFirstName("Elon");
        customer2.setLastName("Musk");
        customer2.setEmail("elon_musk@mail.com");
        customer2.setPassword("foo");
        customerRepository.save(customer2);
    }
}
