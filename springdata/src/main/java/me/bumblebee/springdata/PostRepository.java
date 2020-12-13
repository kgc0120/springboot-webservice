package me.bumblebee.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Repository
//@Transactional

// 오늘날 spring jpa
public interface PostRepository extends JpaRepository<Post, Long> {

//    이런식으로 spring jap에 없는 시절 만들어서 사용하였다.
//    @PersistenceContext // @Autowired 말고 @PersistenceContext 사용 JPA에 있는 애노테이션을 사용하는 거고 Spring Code를 최대한 감출 수 있다.
//    EntityManager entityManager;
//
//    public Post add(Post post) {
//        entityManager.persist(post);
//        return post;
//    }
//
//    public void delete(Post post) {
//        entityManager.remove(post);
//    }
//
//    public List<Post> findAll() {
//        return entityManager.createQuery("SELECT p FROM Post As p", Post.class)
//                            .getResultList();
//    }

}
