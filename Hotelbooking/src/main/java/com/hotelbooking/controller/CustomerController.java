
package com.hotelbooking.controller;

import com.hotelbooking.entity.Customer;
import com.hotelbooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> loginCustomer(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String password = data.get("password");

        Customer customer = customerRepository.findByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
