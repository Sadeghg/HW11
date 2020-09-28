package template.data;

import template.model.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class BaseRepositoryImp<E extends BaseEntity<PK>, PK extends Serializable> implements BaseRepository<E, PK> {

    protected final EntityManager manager;

    public BaseRepositoryImp(EntityManager manager){
        this.manager = manager;
    }

    public void save(E e) {
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
    }

    public void update(E e) {
        manager.getTransaction().begin();
        manager.merge(e);
        manager.getTransaction().commit();
    }

    public E findById(Class<E> e, PK id) {
        manager.getTransaction().begin();
        E res = manager.find(e, id);
        manager.getTransaction().commit();
        return res;
    }

    public void delete(Class<E> e, PK id) {
        manager.getTransaction().begin();
        manager.remove(e);
        manager.getTransaction().commit();
    }

    public List<E> findAll(Class<E> e) {
        return null;
    }


}
