package com.example.demo.service;

import com.example.demo.customer.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jetbrains.exported.JBRApi;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Slf4j
public class OrderService {
    private final Logger log = (Logger) LoggerFactory.getLogger(OrderService.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private String customerBaseUrl;

    private static final String CUSTOMER_ORDER_URL = "customerOrders/";

    public void createOrder(Order order) {
        final var url = customerBaseUrl + CUSTOMER_ORDER_URL + order.getCustomerId();
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        log.info("Order Request URL: {}");
        try {
            final var request = new HttpEntity<>(order, headers);
            final var responseEntity = restTemplate.postForEntity(url, request, Order.class);
           // if (responseEntity.getStatusCode().isError()) {
            //    log.log(Level.parse("For Order ID: {}, error response: {} is received to create Order in Customer Microservice"),
             //           order.getId(),
              //          responseEntity.getStatusCode().getReasonPhrase());
               // throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("For Order UUID: %s, Customer Microservice Message: %s", order.getId(), responseEntity.getStatusCodeValue()));
            //}
            if (responseEntity.hasBody()) {
                log.log(Level.parse("Order From Response: {}"), responseEntity.getBody().getId());
            }
        } catch (Exception e) {
            //log.log("For Order ID: {}, cannot create Order in Customer Microservice for reason: {}", order.getId(), ExceptionUtils.getRootCauseMessage(e));
           // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("For Order UUID: %s, Customer Microservice Response: %d", order.getId(), ExceptionUtils.getRootCauseMessage(e)));
        }
    }
}
