package com.example.demo.account;


import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "gyucheol", roles = "USER") // 메타 애노테이션
// 애노테이션 커스터마이징
public @interface WithUser {
}
