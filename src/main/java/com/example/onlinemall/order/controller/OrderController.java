package com.example.onlinemall.order.controller;


import com.example.onlinemall.customer.entity.Customer;
import com.example.onlinemall.customer.service.CustomerService;
import com.example.onlinemall.order.entity.Order;
import com.example.onlinemall.order.model.OrderDTO;
import com.example.onlinemall.order.service.OrderService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @PostMapping("/add-to-cart")
    public String placeOrder(@ModelAttribute OrderDTO orderDTO, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            // 주문을 생성하고 저장
            orderDTO.setCustomerId(customer.getCustomerId());
            orderService.createOrder(orderDTO);
            return "redirect:/products";
        } else {
            // 고객이 로그인하지 않은 경우 로그인 페이지로 리다이렉트
            return "redirect:/products";
        }
    }

    @GetMapping("/my-cart")
    public String viewMyCart(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
//            return "Customer ID: " + customer.getCustomerId();
            List<Order> orders = orderService.viewMyOrder(customer.getCustomerId());
            model.addAttribute("orders", orders);
            return "cart";
        } else {
            return "Customer not logged in";
        }
    }
}
