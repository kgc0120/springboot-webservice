package me.bumblebee.commonweb.post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {

    @EntityGraph(attributePaths = "post")
    Optional<Comment> getById(Long id);

    @Transactional(readOnly = true)
//    data에 변경이 없이 조회만 하는 쿼리에는 readOnly를 붙여주면 성능이 좋아진다.
//    Flush(db와 동기화는 거) 모드를 NEVER로 설정한다는 것이고, Dirty checking(Persistent 변화를 감지 하는 거)을 하지 않기 때문에
    <T> List<T> findByPostId(Long id, Class<T> type);
//    List<CommentSummary> findByPost_Id(Long id);

}
