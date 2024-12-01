package com.enoca.challenge.service.impl;

import com.enoca.challenge.exception.EnocaException;
import com.enoca.challenge.exception.ErrorMessages;
import com.enoca.challenge.model.Customer;
import com.enoca.challenge.repository.CustomerRepository;
import com.enoca.challenge.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customerRepository;

    // Login Process
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> response = customerRepository.findByEmail(email);

        if(response.isPresent()) {
            Customer customer = response.get();

            return User.builder()
                    .username(customer.getEmail())
                    .password(customer.getPassword())
                    .roles("CUSTOMER")
                    .build();
        }
        else {
            throw EnocaException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.EMAIL_NOT_FOUND);
        }

    }

    // The EMAIL of the user to be processed is provided as a parameter.
    @Override
    public Boolean verifyUserIdMatchesAuthenticatedUser(String email) {
        // The authenticated user's information is accessed.
        String authenticatedUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        // It is checked whether the authenticated user's ID matches the information of the user to be processed.
        return authenticatedUserEmail.equals(email);
    }

}
