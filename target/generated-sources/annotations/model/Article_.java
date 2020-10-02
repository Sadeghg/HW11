package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Article.class)
public abstract class Article_ extends template.model.BaseEntity_ {

	public static volatile SingularAttribute<Article, String> brief;
	public static volatile SingularAttribute<Article, Date> lastUpdateDate;
	public static volatile SingularAttribute<Article, Date> publishedDate;
	public static volatile SingularAttribute<Article, Boolean> state;
	public static volatile SingularAttribute<Article, String> title;
	public static volatile SingularAttribute<Article, Category> category;
	public static volatile SingularAttribute<Article, User> user;
	public static volatile SingularAttribute<Article, String> content;
	public static volatile SingularAttribute<Article, Date> createDate;
	public static volatile SetAttribute<Article, Tag> tags;

}

