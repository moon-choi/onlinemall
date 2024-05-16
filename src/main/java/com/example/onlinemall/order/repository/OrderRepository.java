package com.example.onlinemall.order.repository;

import com.example.onlinemall.customer.entity.Customer;
import com.example.onlinemall.order.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByCustomer(Customer customer);
}
