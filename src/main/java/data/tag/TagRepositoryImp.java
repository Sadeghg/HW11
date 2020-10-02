package data.tag;

import model.Tag;
import model.helper.TagInfo;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class TagRepositoryImp extends BaseRepositoryImp<Tag, Integer, TagInfo> implements TagRepository {
    public TagRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public Tag findByTitle(String title) {
        Tag tag = null;
        try {
            tag = manager.createNamedQuery("Tag.findByTitle", Tag.class)
                    .setParameter("title", title)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println("\u001B[31m  \u001B[0m");
        }
        return tag;
    }

    public void delete(Tag tag) {
        manager.getTransaction().begin();
        manager.remove(tag);
        manager.getTransaction().commit();
    }
}
