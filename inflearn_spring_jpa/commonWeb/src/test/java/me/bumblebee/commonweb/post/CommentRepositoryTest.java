package me.bumblebee.commonweb.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void getComment() {
        // 내가 원하는 패칭 전략을 여러개 사용 가능하다.
        // FETCH : 설정한 엔티티 애트리뷰트는 EAGER 패치 나머지는 LAZY 패치
        commentRepository.getById(1l);

        System.out.println("=========================");

        commentRepository.findById(1l);
    }
}