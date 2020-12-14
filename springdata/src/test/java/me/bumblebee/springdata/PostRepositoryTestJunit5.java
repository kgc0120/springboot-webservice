package me.bumblebee.springdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertNull;

@DataJpaTest
public class PostRepositoryTestJunit5 {

    @Autowired
    PostRepository postRepository;

    @Test
    @DisplayName("Junit5 Test")
    void crudRepository() {
        Post post = new Post();

        post.setTitle("hello spring boot common");
        assertNull(post.getId());

        // When
        Post newPost = postRepository.save(post);
    }
}
