package me.bumblebee.commonweb.post;

import javax.persistence.*;

@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String commnet;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommnet() {
        return commnet;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
