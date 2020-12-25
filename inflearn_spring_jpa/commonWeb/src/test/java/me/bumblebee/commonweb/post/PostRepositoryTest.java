package me.bumblebee.commonweb.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);  // persist

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("hibernate");
        Post updatedPost = postRepository.save(postUpdate); // merge
//       Merge() 메소드에 넘긴 그 엔티티의 복사본을 만들고,
//       그 복사본을 다시 Persistent 상태로 변경하고 그 복사본을 반환합니다.
//       무조건 리턴받은 값을 사용해라 postUpdate.setTitle("bumblebee"); 사용하지 말고
        updatedPost.setTitle("bumblebee");

        List<Post> all = postRepository.findAll();
        assertEquals(all.size(), 1);
    }

    @Test
    void findByTileStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartingWith("Spring");
        assertEquals(all.size(), 1);
    }

    @Test
    void findByTitle() {
        savePost();

        List<Post> all = postRepository.findByTitle("Spring", JpaSort.unsafe("LENGTH(title)")/*Sort.by("title")*/); // sort 프로퍼티나 alias만 사용가능
//      LENGTH(title)이와 같이 정렬 사용하고 싶으면 JpaSort.unsafe사용
        assertEquals(all.size(), 1);
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring");
        return postRepository.save(post);
    }

    @Test
    void updateTitle() {
//        추천하지 않는 방법
//        Post post = savePost();
//        String hibernate = "hibernate";
//        int update = postRepository.updateTitle(hibernate, post.getId());
//        assertEquals(update, 1);
//
//        Optional<Post> byId = postRepository.findById(post.getId());
//        assertEquals(byId.get().getTitle(), hibernate);

//       추천하는 방법
        Post spring = savePost();
        spring.setTitle("hibernate");

        List<Post> all = postRepository.findAll();
        assertEquals(all.get(0).getTitle(), "hibernate");

    }


}