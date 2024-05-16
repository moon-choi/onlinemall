package com.example.onlinemall.order.service;

import com.example.onlinemall.customer.entity.Customer;
import com.example.onlinemall.customer.service.CustomerService;
import com.example.onlinemall.order.entity.Order;
import com.example.onlinemall.order.model.OrderDTO;
import com.example.onlinemall.order.repository.OrderRepository;
import com.example.onlinemall.product.entity.Product;
import com.example.onlinemall.product.service.ProductService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order();

        Customer customer = customerService.findByCustomerId(orderDTO.getCustomerId());
        order.setCustomer(customer);

        Product product = productService.findByProductNumber(orderDTO.getProductNumber());
        order.setProduct(product);
        order.setQuantity(orderDTO.getQuantity());
        order.setOrderDate(LocalDateTime.now());

        orderRepository.save(order);
    }

    public List<Order> viewMyOrder(String customerId) {
        Customer customer = customerService.findByCustomerId(customerId);
        return orderRepository.findAllByCustomer(customer);
    }

    //여기서 로그인한 유저의 주문을 찾기...
}
