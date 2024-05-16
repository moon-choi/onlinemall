package com.example.onlinemall.customer.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
public class Customer {

    @Id
    @Column(name = "customer_id")
    private String customerId;
    private String password;
    private String customerName;
    private int age;
    private String rating;
    private String occupation;
    private int reserves;


    public Customer(String customerId) {
        this.customerId = customerId;
    }
}