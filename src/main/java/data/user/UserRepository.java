package data.user;

import model.User;
import template.data.BaseRepository;

public interface UserRepository extends BaseRepository<User, Integer> {

    User findUserByUsername(String username);
}
