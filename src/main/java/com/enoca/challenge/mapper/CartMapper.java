package com.enoca.challenge.mapper;

import com.enoca.challenge.dto.CartDto;
import com.enoca.challenge.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper extends BaseMapper<Cart, CartDto> {



}
