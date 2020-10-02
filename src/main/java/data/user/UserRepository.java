package data.user;

import model.User;
import model.helper.UserInfo;
import template.data.BaseRepository;

public interface UserRepository extends BaseRepository<User, Integer, UserInfo> {

    User findUserByUsername(String username);

    User login(String username, String password);
}
