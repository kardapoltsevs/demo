package com.example.demo.customer;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "customer")
@Data
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field("orders")
    private Set<@Valid Order> orders = new HashSet<com.example.demo.customer.@Valid Order>();

    public Customer addOrder(com.example.demo.customer.@Valid Order order) {
        this.orders.add(order);
        return this;
    }
}
