package data.tag;

import model.Tag;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;

public class TagRepositoryImp extends BaseRepositoryImp<Tag, Integer> implements TagRepository {
    public TagRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public Tag findByTitle(String title) {
        return manager.createNamedQuery("Tag.findByTitle", Tag.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    public void delete(Tag tag) {
        manager.getTransaction().begin();
        manager.remove(tag);
        manager.getTransaction().commit();
    }
}
