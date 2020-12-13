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

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//        account.setUsername("gyucheol");
//        account.setPassword("hibernate");
//
//        Study study = new Study();
//        study.setName("Spring Data JPA");
////        ============================= 여기까지 Transient 상태 hibernate가 이 객체에 대해서 전혀 모른다.
//        account.addStudy(study);
//
//        Session session = entityManager.unwrap(Session.class); // hibernate도 사용가능하다.
//        session.save(account); // 저장을 하면 Persistent 상태 jpa가 아는 상태가 된다.
//        session.save(study);
////        entityManager.persist(account);
//
//        Account gyucheol = session.load(Account.class, account.getId()); // select query가 발생하지 않는다. 아직 insert를 하지않음, hibernate가 persistent 객체를 관리하는 장점중의 하나
//        gyucheol.setUsername("gyucheol2"); // update query 발생, update를 시키지도 않았는데 이게 바로 Dirty Checking, Write Behind
////        Dirty Checking - 이 객체의 변경 사항을 계속 감지한다는 것
////        Write Behind - 객체의 상태 변화를 최대한 늦게, 최대한 필요한 시점에 데이터베이스에 반영한다는 것
//        System.out.println("=======================");
//        System.out.println(gyucheol.getUsername());
//
////        return gyucheol 이런식으로 return 해서 repository에서 service로 리턴 받을 때 Detached 상태
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post = new Post();
//        post.setTitle("Spring Data JPA 언제 보나...");
//
//        Comment comment = new Comment();
//        comment.setCommnet("빨리 보고 싶어요.");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setCommnet("곧 보여드릴께요.");
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
//        session.save(post);
        Post post = session.get(Post.class, 1l);
        session.delete(post);
    }


}

