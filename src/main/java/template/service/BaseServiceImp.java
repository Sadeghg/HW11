package template.service;

import model.helper.BaseInfo;
import template.data.BaseRepository;
import template.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class BaseServiceImp<E extends BaseEntity<PK> , PK extends Serializable, Repository extends BaseRepository<E, PK, S>, S extends BaseInfo> implements BaseService<E, PK, S> {

    protected final Repository repository;

    public BaseServiceImp(Repository repository){
        this.repository = repository;
    }

    @Override
    public void save(E e) {
        repository.save(e);
    }

    @Override
    public void update(E e) {
        repository.update(e);
    }

    @Override
    public E findById(Class<E> e, PK id) {
        return repository.findById(e, id);
    }

    @Override
    public void delete(Class<E> e, PK id) {
        repository.delete(e, id);
    }

    @Override
    public List<E> findAll(Class<E> e, String query) {
        return repository.findAll(e, query);
    }

    @Override
    public List<S> findAll(Class<E> e, String query, Function<E, S> function) {
        return repository.findAll(e, query, function);
    }

    @Override
    public List<E> findAll(Class<E> e, String query, Predicate<E> predicate) {
        return repository.findAll(e, query, predicate);
    }

}
