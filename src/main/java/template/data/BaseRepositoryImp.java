package template.data;

import model.helper.BaseInfo;
import template.model.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BaseRepositoryImp<E extends BaseEntity<PK>, PK extends Serializable, S extends BaseInfo> implements BaseRepository<E, PK, S> {

    protected final EntityManager manager;

    public BaseRepositoryImp(EntityManager manager){
        this.manager = manager;
    }

    public void save(E e) {
        try{
            manager.getTransaction().begin();
            manager.persist(e);
            manager.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            manager.getTransaction().rollback();
        }

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

    public List<E> findAll(Class<E> e, String query) {
        return manager.createNamedQuery(query, e).getResultList();
    }

    @Override
    public List<E> findAll(Class<E> e, String query, Predicate<E> predicate) {
        return findAll(e, query).stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<S> findAll(Class<E> e, String query, Function<E, S> function) {
        return findAll(e, query).stream().map(function).collect(Collectors.toList());
    }


}
