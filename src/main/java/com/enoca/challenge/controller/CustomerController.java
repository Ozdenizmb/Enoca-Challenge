package com.enoca.challenge.controller;

import com.enoca.challenge.api.CustomerApi;
import com.enoca.challenge.dto.CustomerCreateDto;
import com.enoca.challenge.dto.CustomerDto;
import com.enoca.challenge.dto.CustomerUpdateDto;
import com.enoca.challenge.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class CustomerController implements CustomerApi {

    private final CustomerService service;

    @Override
    public ResponseEntity<UUID> addCustomer(CustomerCreateDto customerCreateDto) {
        return ResponseEntity.ok(service.addCustomer(customerCreateDto));
    }

    @Override
    public ResponseEntity<CustomerDto> loginCustomer(String email, String password) {
        return ResponseEntity.ok(service.loginCustomer(email, password));
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomer(String email) {
        return ResponseEntity.ok(service.getCustomer(email));
    }

    @Override
    public ResponseEntity<Page<CustomerDto>> getCustomers(Pageable pageable) {
        return ResponseEntity.ok(service.getCustomers(pageable));
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(UUID id, CustomerUpdateDto customerUpdateDto) {
        return ResponseEntity.ok(service.updateCustomer(id, customerUpdateDto));
    }

    @Override
    public ResponseEntity<Boolean> deleteCustomer(UUID id) {
        return ResponseEntity.ok(service.deleteCustomer(id));
    }

}
