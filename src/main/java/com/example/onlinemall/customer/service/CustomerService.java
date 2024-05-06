package com.example.onlinemall.customer.service;

import com.example.onlinemall.customer.entity.Customer;
import com.example.onlinemall.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

//    public CustomerDTO login(CustomerDTO customerDTO) {
//        //일단 ID로 찾기
//        Optional<Customer> byCustomerId = customerRepository.findByCustomerId(
//            customerDTO.getCustomerId());
//
//        //ID가 있으면
//        if (byCustomerId.isPresent()) {
//            Customer customer = byCustomerId.get();
//            //비밃번호 일치하는지 확인
//            if (customer.getPassword().equals(customerDTO.getPassword())) {
//                return customerConverter.toDTO(customer);
//            }
//        }
//        return null;
//    }

    public Customer login(String customerId, String password) {
        return customerRepository.findByCustomerIdAndPassword(customerId, password);
    }
}
