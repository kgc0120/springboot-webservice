package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// 어떤 요청들을 어떻게 인가 할지(허용할지)에 대한 설정
                .mvcMatchers("/", "info").permitAll()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated(); //기타 등등의미

        http.formLogin()
                .and() // 메소드 체이닝 사용 안해도 상관없음
            .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("gyucheol").password("{noop}123").roles("USER").and()
                // DB에 들어간 값이라고 생각하면 된다 {noop}123 {noop} prefix는 암호화를 안했다는 prefix
                .withUser("admin").password("{noop}!@#").roles("ADMIN");
    }
}
