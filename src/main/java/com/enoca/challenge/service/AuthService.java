package com.enoca.challenge.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    Boolean verifyUserIdMatchesAuthenticatedUser(String email);

}
