package me.bumblebee.demojpa2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix = "Default", repositoryBaseClass = SimplMyRepository.class) // Impl말고 접미어 다른 거 살정하고 싶을때.. 거의 없을듯...
public class Demojpa2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demojpa2Application.class, args);
    }

}
