package me.bumblebee.springdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(value = false)
    public void crudRepository() {
        // Given
        Post post = new Post();

        post.setTitle("hello spring boot common");
        assertNull(post.getId());

        // When
        Post newPost = postRepository.save(post);

        // Then
        assertNotNull(newPost.getId());

        // When
        List<Post> posts = postRepository.findAll();
        assertEquals(posts.size(), 1);
        assertTrue(posts.contains(newPost));

        // When
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        assertEquals(page.getTotalElements(), 1);
        assertEquals(page.getNumber(), 0);
        assertEquals(page.getSize(), 10);
        assertEquals(page.getNumberOfElements(), 1);

        // When
        postRepository.findByTitleContains("spring", PageRequest.of(0, 10));

        // Then
        assertEquals(page.getTotalElements(), 1);
        assertEquals(page.getNumber(), 0);
        assertEquals(page.getSize(), 10);
        assertEquals(page.getNumberOfElements(), 1);
    }

}