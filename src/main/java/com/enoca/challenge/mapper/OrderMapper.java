package com.enoca.challenge.mapper;

import com.enoca.challenge.dto.OrderDto;
import com.enoca.challenge.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderDto> {



}
