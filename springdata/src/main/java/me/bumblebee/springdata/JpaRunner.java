package me.bumblebee.springdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; // EntityManager 이 class가 jpa 핵심! 이 클래스를 가지고 entity들을 영속화할 수 있다.
    //영속화 한다? db에 저장한다라는 뜻

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("gyucheol");
        account.setPassword("hibernate");


        Session session = entityManager.unwrap(Session.class); // hibernate도 사용가능하다.
        session.save(account);
//        entityManager.persist(account);
    }
}
