package data.user;

import model.User;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;

public class UserRepositoryImp extends BaseRepositoryImp<User, Integer> implements UserRepository{
    public UserRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public User findUserByUsername(String username) {
        return manager.createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
