package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends template.model.BaseEntity_ {

	public static volatile SingularAttribute<User, Date> birthDay;
	public static volatile SingularAttribute<User, String> nationalCode;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Address> address;
	public static volatile SingularAttribute<User, Role> role;
	public static volatile SingularAttribute<User, String> userName;

}

