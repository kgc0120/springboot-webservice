package me.bumblebee.commonweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountAuditAware") // bean 이름으로 설정
public class Applilcation {

    public static void main(String[] args) {
        SpringApplication.run(Applilcation.class, args);
    }

}
