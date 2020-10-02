package data.user;

import model.User;
import model.helper.UserInfo;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UserRepositoryImp extends BaseRepositoryImp<User, Integer, UserInfo> implements UserRepository{
    public UserRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public User findUserByUsername(String username) {
        User user = null;
        try {
            user = manager.createNamedQuery("User.findByUsername", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println("\u001B[31mNo such user found \u001B[0m");
        }
        return user;
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            user = manager.createNamedQuery("User.login", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println("\u001B[31mUsername or Password wrong \u001B[0m");
        }
        return user;
    }
}
