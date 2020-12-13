package me.bumblebee.springdata;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

      @Autowired
      PostRepository postRepository;


//    @PersistenceContext
//    EntityManager entityManager; // EntityManager 이 class가 jpa 핵심! 이 클래스를 가지고 entity들을 영속화할 수 있다.
    //영속화 한다? db에 저장한다라는 뜻

    @Override
    public void run(ApplicationArguments args) throws Exception {
        postRepository.findAll().forEach(System.out::println);
    }

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

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
////        Post post = new Post();
////        post.setTitle("Spring Data JPA 언제 보나...");
////
////        Comment comment = new Comment();
////        comment.setCommnet("빨리 보고 싶어요.");
////        post.addComment(comment);
////
////        Comment comment1 = new Comment();
////        comment1.setCommnet("곧 보여드릴께요.");
////        post.addComment(comment1);
//
//        Session session = entityManager.unwrap(Session.class);
////        session.save(post);
//        Post post = session.get(Post.class, 4l);
////        session.delete(post);
//        System.out.println("===================================");
//        System.out.println(post.getTitle());
//
////      연관 관계의 엔티티를 어떻게 가져올 것인가 지금(Eager) 나중에(Lazy)
////      @OneToMany의 기본값은 Lazy
////      @ManyToOne의 기본값은 Eager
//        post.getComents().forEach( c ->{
//            System.out.println("-----------------------");
//            System.out.println(c.getCommnet());
//        });
//
//    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
////        JPQL (HQL)
////        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class); // JPQL 단점 : Type Safe 하지않다.
////        List<Post> posts = query.getResultList();
////        posts.forEach(System.out::println);
//
////      Criteria
////        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
////        CriteriaQuery<Post> query = builder.createQuery(Post.class);
////        Root<Post> root = query.from(Post.class);
////        query.select(root);
////
////        List<Post> posts = entityManager.createQuery(query).getResultList();
////        posts.forEach(System.out::println);
//
////      Native Query
//        List<Post> posts = entityManager.createNativeQuery("Select * from Post", Post.class).getResultList();
//        posts.forEach(System.out::println);
//
//    }


}

