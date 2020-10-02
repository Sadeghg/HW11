package service.user;

import model.User;
import model.helper.UserInfo;
import template.service.BaseService;

public interface UserService extends BaseService<User, Integer, UserInfo> {

    User findUserByUsername(String title);

    User login(String username, String password);
}
