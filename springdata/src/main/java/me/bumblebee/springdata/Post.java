package me.bumblebee.springdata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // 보통은 CascadeType.ALL 사용 모두 다 전파 시킨다.
    // cascade = CascadeType.PERSIST 저장할 때 저장 할 Persistent를 아래 comments에 전파해주세요 의미
    private Set<Comment> coments = new HashSet<>();

    public void addComment(Comment comment) {
        this.getComents().add(comment);
        comment.setPost(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComents() {
        return coments;
    }

    public void setComents(Set<Comment> coments) {
        this.coments = coments;
    }
}
