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
        this.createComment(100, "spring data jpa");
        this.createComment(55, "hibernate spring");

        List<Comment> comments = commentRepository.findByCommnetContainsIgnoreCaseOrderByLikeCountDesc("Spring");
        assertEquals(comments.size(), 2);


    }

    private void createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setCommnet(comment);
        commentRepository.save(newComment);
    }


}