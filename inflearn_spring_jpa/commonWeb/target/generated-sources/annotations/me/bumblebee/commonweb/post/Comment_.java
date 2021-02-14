package me.bumblebee.commonweb.post;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comment.class)
public abstract class Comment_ {

	public static volatile SingularAttribute<Comment, Account> updatedBy;
	public static volatile SingularAttribute<Comment, Post> post;
	public static volatile SingularAttribute<Comment, Account> createdBy;
	public static volatile SingularAttribute<Comment, Date> created;
	public static volatile SingularAttribute<Comment, String> commnet;
	public static volatile SingularAttribute<Comment, Boolean> best;
	public static volatile SingularAttribute<Comment, Long> id;
	public static volatile SingularAttribute<Comment, Integer> up;
	public static volatile SingularAttribute<Comment, Integer> down;
	public static volatile SingularAttribute<Comment, Date> updated;

	public static final String UPDATED_BY = "updatedBy";
	public static final String POST = "post";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED = "created";
	public static final String COMMNET = "commnet";
	public static final String BEST = "best";
	public static final String ID = "id";
	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String UPDATED = "updated";

}

