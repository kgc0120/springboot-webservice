package me.bumblebee.demojpa2.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(PostRepositoryTestConfig.class)
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void crud() {
//        postRepository.findMyPost();
        Post post = new Post();
        post.setTitle("hibernate");

        assertFalse(postRepository.contains(post)); //객체 상태가 트랜지언트 상태

        postRepository.save(post).publish();

        assertTrue(postRepository.contains(post)); // 객체 상태가 펄시스턴트 상태로 변경

//        postRepository.findMyPost(); // insert 쿼리 날아가게 해준다. insert는 select에 영향을 주니까

        // delete 쿼리 안날림 왜? test 코드는 트랜잭션널이라서 rollback 하니까 hibernate가 불 필요한 쿼리를 날리지 않는다.
        postRepository.delete(post);
        postRepository.flush(); // 싱크를 해준다 delete 쿼리를 날린다.
    }
}