package com.enoca.challenge.service.impl;

import com.enoca.challenge.dto.CustomerCreateDto;
import com.enoca.challenge.dto.CustomerDto;
import com.enoca.challenge.dto.CustomerUpdateDto;
import com.enoca.challenge.mapper.CustomerMapper;
import com.enoca.challenge.repository.CustomerRepository;
import com.enoca.challenge.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public UUID addCustomer(CustomerCreateDto customerCreateDto) {
        return null;
    }

    @Override
    public CustomerDto loginCustomer(String email, String password) {
        return null;
    }

    @Override
    public CustomerDto getCustomer(String email) {
        return null;
    }

    @Override
    public Page<CustomerDto> getCustomers(Pageable pageable) {
        return null;
    }

    @Override
    public CustomerDto updateCustomer(UUID id, CustomerUpdateDto customerUpdateDto) {
        return null;
    }

    @Override
    public Boolean deleteCustomer(UUID id) {
        return null;
    }
}
