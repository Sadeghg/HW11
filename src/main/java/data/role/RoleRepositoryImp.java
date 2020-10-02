package data.role;

import model.Role;
import model.helper.RoleInfo;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;

public class RoleRepositoryImp extends BaseRepositoryImp<Role, Integer, RoleInfo> implements RoleRepository {
    public RoleRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public Role findByTitle(String title) {
        return manager.createNamedQuery("Role.findByTitle", Role.class)
                .setParameter("title", title)
                .getSingleResult();
    }
}
