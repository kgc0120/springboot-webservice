package me.bumblebee.springdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("Repository 직접 정의해서 사용하기")
    void crud() {
        Comment comment = new Comment();
        comment.setCommnet("Hello Comment");
        commentRepository.save(comment);

        List<Comment> all = commentRepository.findAll();
        assertEquals(all.size(), 1);

        long count = commentRepository.count();
        assertEquals(count, 1);

    }


}