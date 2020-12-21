package me.bumblebee.demojpa2.post;

import me.bumblebee.demojpa2.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {
    // 기본 구현체인 SimpleMyRepository가  QuerydslPredicateExecutor의 구현체를 구현하지 않아서 에러 발생
}
