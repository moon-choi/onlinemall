package com.example.onlinemall.customer.service;

import com.example.onlinemall.customer.entity.Customer;
import com.example.onlinemall.customer.model.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter {

    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
            .customerId(customer.getCustomerId())
            .password(customer.getPassword())
            .build();
    }

}
