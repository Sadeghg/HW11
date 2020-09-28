package template.service;

import template.data.BaseRepository;
import template.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImp<E extends BaseEntity<PK> , PK extends Serializable, Repository extends BaseRepository<E, PK>> implements BaseService<E, PK> {

    protected final Repository repository;

    public BaseServiceImp(Repository repository){
        this.repository = repository;
    }

    public void save(E e) {
        repository.save(e);
    }

    public void update(E e) {
        repository.update(e);
    }

    public E findById(Class<E> e, PK id) {
        return repository.findById(e, id);
    }

    public void delete(Class<E> e, PK id) {
        repository.delete(e, id);
    }

    public List<E> findAll(Class<E> e) {
        return null;
    }
}
