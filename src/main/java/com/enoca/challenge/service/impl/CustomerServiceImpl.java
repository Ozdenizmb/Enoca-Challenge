package com.enoca.challenge.service.impl;

import com.enoca.challenge.dto.CustomerCreateDto;
import com.enoca.challenge.dto.CustomerDto;
import com.enoca.challenge.dto.CustomerUpdateDto;
import com.enoca.challenge.exception.EnocaException;
import com.enoca.challenge.exception.ErrorMessages;
import com.enoca.challenge.mapper.CustomerMapper;
import com.enoca.challenge.mapper.PageMapperHelper;
import com.enoca.challenge.model.Customer;
import com.enoca.challenge.repository.CustomerRepository;
import com.enoca.challenge.service.AuthService;
import com.enoca.challenge.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @Override
    public UUID addCustomer(CustomerCreateDto customerCreateDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerCreateDto, customer);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return repository.save(customer).getId();
    }

    @Override
    public CustomerDto loginCustomer(String email, String password) {
        Optional<Customer> responseCustomer = repository.findByEmail(email);

        if(responseCustomer.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.CUSTOMER_NOT_FOUND);
        }

        Customer existCustomer = responseCustomer.get();

        if(passwordEncoder.matches(password, existCustomer.getPassword())) {
            return mapper.toDto(existCustomer);
        }
        else {
            throw EnocaException.withStatusAndMessage(HttpStatus.UNAUTHORIZED, ErrorMessages.WRONG_PASSWORD);
        }
    }

    @Override
    public CustomerDto getCustomer(String email) {
        Optional<Customer> responseCustomer = repository.findByEmail(email);

        if(responseCustomer.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.CUSTOMER_NOT_FOUND);
        }

        return mapper.toDto(responseCustomer.get());
    }

    @Override
    public Page<CustomerDto> getCustomers(Pageable pageable) {
        Page<Customer> costumers = repository.findAll(pageable);

        if(costumers.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.CUSTOMER_NOT_FOUND);
        }

        return PageMapperHelper.mapEntityPageToDtoPage(costumers, mapper);
    }

    private Customer fetchCustomerWithValidation(UUID id) {
        Optional<Customer> responseCustomer = repository.findById(id);

        if(responseCustomer.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.CUSTOMER_NOT_FOUND);
        }

        Customer customer = responseCustomer.get();

        if(!authService.verifyUserIdMatchesAuthenticatedUser(customer.getEmail())) {
            throw EnocaException.withStatusAndMessage(HttpStatus.FORBIDDEN, ErrorMessages.FORBIDDEN);
        }

        return customer;
    }

    @Override
    public CustomerDto updateCustomer(UUID id, CustomerUpdateDto customerUpdateDto) {
        Customer customer = fetchCustomerWithValidation(id);
        BeanUtils.copyProperties(customerUpdateDto, customer);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return mapper.toDto(repository.save(customer));
    }

    @Override
    public Boolean deleteCustomer(UUID id) {
        Customer customer = fetchCustomerWithValidation(id);
        repository.delete(customer);

        return true;
    }
}
