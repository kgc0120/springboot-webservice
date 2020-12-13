package me.bumblebee.springdata;

import javax.persistence.*;
import java.util.Date;

@Entity
// 특정 db에서는 user라는 테이블을 만들 수가 없다.(postgres)
public class Account {

    @Id @GeneratedValue // @GeneratedValue 자동으로 생성되는 값을 사용하겠다라는 의미
    private Long id;
    // long - primitive type, id가 0으로 세팅됨
    // Long - wrapper type,

    // properties에서 spring.jpa.hibernate.ddl-auto = update 해놓았다면 @Column 옵션을 변경해도 적용되지 않는다.
    // 이미 칼럼이 만들어져있기 때문에
    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;

    public Account() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
