package com.enoca.challenge.mapper;

import com.enoca.challenge.dto.ProductDto;
import com.enoca.challenge.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {



}
