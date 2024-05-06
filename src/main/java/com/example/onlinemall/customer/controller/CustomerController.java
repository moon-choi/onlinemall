package com.example.onlinemall.customer.controller;

import com.example.onlinemall.customer.entity.Customer;
import com.example.onlinemall.customer.model.CustomerDTO;
import com.example.onlinemall.customer.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/login")
    public String login(CustomerDTO customerDTO, HttpSession session) {

        Customer customer = customerService.login(customerDTO.getCustomerId(),
            customerDTO.getPassword());

        if (customer != null) {
            session.setAttribute("customer", customer);
        }
        return "redirect:/products";
    }
//
////@PostMapping("/logout")
////public String logout(HttpSession session) {
////    session.invalidate();
////    return "redirect:/";
////}

//    @PostMapping("/login")
//    public String login(String customerId, String password, HttpSession session, Model model) {
//        Customer customer = customerService.login(customerId, password);
//        if (customer != null) {
//            session.setAttribute("customerId", customerId);
//            return "redirect:/products";
//        } else {
//            model.addAttribute("error", "Invalid ID or password");
//            return "redirect:/products";
//        }
//    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/products";
    }

}
