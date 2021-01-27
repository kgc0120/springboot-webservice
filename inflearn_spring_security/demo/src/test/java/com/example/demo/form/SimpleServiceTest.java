package com.example.demo.form;

import com.example.demo.account.Account;
import com.example.demo.account.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleServiceTest {

    @Autowired
    SimpleService simpleService;

    @Autowired
    AccountService accountService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Test
    @WithMockUser
    void dashboard() {
//        Account account = new Account();
//        account.setRole("USER");
//        account.setUsername("gyucheol");
//        account.setPassword("123");
//        accountService.createNew(account);
//
//        UserDetails userDetails = accountService.loadUserByUsername("gyucheol");
////       UserDetailsService에서 반환해주는 userDetails 이 객체가 곧 principal이다.
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, "123");
//        Authentication authentication = authenticationManager.authenticate(token);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        simpleService.dashboard();
    }

}