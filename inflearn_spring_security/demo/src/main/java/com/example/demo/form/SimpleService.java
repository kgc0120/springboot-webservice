package com.example.demo.form;

import com.example.demo.account.Account;
import com.example.demo.account.AccountContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SimpleService {


    public void dashboard() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = authentication.getPrincipal(); //principal -> userDetail 사용자 정보 담겨져있다.
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();// 사용자 권한을 나타낸다. user일수도있고 admin일수도 있고
//        Object credentials = authentication.getCredentials();
//        boolean authenticated = authentication.isAuthenticated(); // 인증된 사용자냐

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("==============");
        System.out.println(userDetails.getUsername());

    }
}
