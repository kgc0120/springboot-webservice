package me.bumblebee.commonweb.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleStartingWith(String title);

    @Query(value = "SELECT p FROM Post AS p WHERE p.title = :title")
    List<Post> findByTitle(@Param("title") String keyword, Sort sort);

    @Modifying(clearAutomatically = true)
    @Query("update Post p Set p.title = ?1 where p.id = ?2")
    int updateTitle(String hibernate, Long id);
}
