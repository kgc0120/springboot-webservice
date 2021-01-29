package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableAsync
public class DemoApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // {noop} prefix 사용할 필요없음
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
