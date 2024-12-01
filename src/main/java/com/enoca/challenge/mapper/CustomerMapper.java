package com.enoca.challenge.mapper;

import com.enoca.challenge.dto.CustomerDto;
import com.enoca.challenge.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {



}
