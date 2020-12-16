package me.bumblebee.springdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
        Comment spring_data_jpa = this.createComment(100, "spring data jpa");
        this.createComment(55, "hibernate spring");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));

        Page<Comment> comments = commentRepository.findByCommnetContainsIgnoreCase("Spring", pageRequest);
        assertEquals(comments.getNumberOfElements(), 2);
        assertEquals(comments.get().findFirst().get(), spring_data_jpa);

    }

    private Comment createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setCommnet(comment);
        commentRepository.save(newComment);
        return newComment;
    }


}