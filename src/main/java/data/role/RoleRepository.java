package data.role;

import model.Role;
import model.helper.RoleInfo;
import template.data.BaseRepository;

public interface RoleRepository extends BaseRepository<Role, Integer, RoleInfo> {

    Role findByTitle(String title);
}
