package service.role;

import model.Role;
import model.helper.RoleInfo;
import template.service.BaseService;

public interface RoleService extends BaseService<Role, Integer, RoleInfo> {

    Role findByTitle(String title);

}
