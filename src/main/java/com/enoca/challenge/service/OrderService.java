package com.enoca.challenge.service;

import com.enoca.challenge.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderService {

    OrderDto placeOrder(UUID customerId);
    OrderDto getOrderForCode(UUID OrderId);
    Page<OrderDto> getAllOrdersForCustomer(UUID customerId, Pageable pageable);

}
