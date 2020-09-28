package data.role;

import model.Role;
import template.data.BaseRepository;

public interface RoleRepository extends BaseRepository<Role, Integer> {

    Role findByTitle(String title);
}
