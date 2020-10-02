package service.role;

import data.role.RoleRepository;
import model.Role;
import model.helper.RoleInfo;
import template.service.BaseServiceImp;


public class RoleServiceImp extends BaseServiceImp<Role, Integer, RoleRepository, RoleInfo> implements RoleService {

    public RoleServiceImp(RoleRepository repository) {
        super(repository);
    }

    public Role findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
