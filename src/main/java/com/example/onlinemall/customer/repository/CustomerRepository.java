package com.example.onlinemall.customer.repository;

import com.example.onlinemall.customer.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    public Optional<Customer> findByCustomerId(String customerId);

    public Customer findByCustomerIdAndPassword(String customerId, String password);
}
