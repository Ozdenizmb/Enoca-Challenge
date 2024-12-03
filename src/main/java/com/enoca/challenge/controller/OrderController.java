package com.enoca.challenge.controller;

import com.enoca.challenge.api.OrderApi;
import com.enoca.challenge.dto.OrderDto;
import com.enoca.challenge.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class OrderController implements OrderApi {

    private final OrderService service;

    @Override
    public ResponseEntity<OrderDto> placeOrder(UUID customerId) {
        return ResponseEntity.ok(service.placeOrder(customerId));
    }

    @Override
    public ResponseEntity<OrderDto> getOrderForCode(UUID orderId) {
        return ResponseEntity.ok(service.getOrderForCode(orderId));
    }

    @Override
    public ResponseEntity<Page<OrderDto>> getAllOrdersForCustomer(UUID customerId, Pageable pageable) {
        return ResponseEntity.ok(service.getAllOrdersForCustomer(customerId, pageable));
    }
}
