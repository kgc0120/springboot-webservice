package me.bumblebee.springdata;

import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long>{

    // 미리 정의해 둔 쿼리 찾아 사용하기
//    @Query("SELECT c from Comment AS c")
    // 메소드 이름을 분석해서 쿼리 만들기
    Page<Comment> findByCommnetContainsIgnoreCase(String keyword, Pageable pageable);

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

}
