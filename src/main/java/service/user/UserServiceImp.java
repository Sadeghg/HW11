package service.user;

import data.user.UserRepository;
import model.User;
import model.helper.UserInfo;
import template.service.BaseServiceImp;

public class UserServiceImp extends BaseServiceImp<User, Integer, UserRepository, UserInfo> implements UserService {
    public UserServiceImp(UserRepository repository) {
        super(repository);
    }

    public User findUserByUsername(String title) {
        return repository.findUserByUsername(title);
    }

    @Override
    public User login(String username, String password) {
        return repository.login(username, password);
    }

}
