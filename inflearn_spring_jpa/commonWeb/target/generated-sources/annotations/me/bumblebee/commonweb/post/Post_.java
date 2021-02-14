package me.bumblebee.commonweb.post;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Post.class)
public abstract class Post_ {

	public static volatile SingularAttribute<Post, Date> created;
	public static volatile SingularAttribute<Post, Long> id;
	public static volatile SingularAttribute<Post, String> title;

	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String TITLE = "title";

}

