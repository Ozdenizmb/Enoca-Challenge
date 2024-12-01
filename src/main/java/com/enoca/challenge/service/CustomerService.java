package com.enoca.challenge.service;

import com.enoca.challenge.dto.CustomerCreateDto;
import com.enoca.challenge.dto.CustomerDto;
import com.enoca.challenge.dto.CustomerUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CustomerService {

    UUID addCustomer(CustomerCreateDto customerCreateDto);
    CustomerDto loginCustomer(String email, String password);
    CustomerDto getCustomer(String email);
    Page<CustomerDto> getCustomers(Pageable pageable);
    CustomerDto updateCustomer(UUID id, CustomerUpdateDto customerUpdateDto);
    Boolean deleteCustomer(UUID id);

}
