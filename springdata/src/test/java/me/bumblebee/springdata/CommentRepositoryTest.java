package me.bumblebee.springdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("Repository 직접 정의해서 사용하기")
    void crud() {
//        Comment comment = new Comment();
//        comment.setCommnet("Hello Comment");
//        commentRepository.save(comment);
//
//        List<Comment> all = commentRepository.findAll();
//        assertEquals(all.size(), 1);
//
//        long count = commentRepository.count();
//        assertEquals(count, 1);

//        Optional<Comment> byId = commentRepository.findById(100l);
//        // 단일 값들은 null이 나올 수 있는데 list는 null이 안나오고 비어있는 list가 나온다.
//        assertEquals(Optional.empty(), byId);
//        Comment comment = byId.orElseThrow(IllegalArgumentException::new);

        commentRepository.save(null);

    }


}