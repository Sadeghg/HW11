package template.service;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface BaseService<E, PK extends Serializable, S>{

    void save(E e);

    void update(E e);

    E findById(Class<E> e, PK id);

    void delete(Class<E> e, PK id);

    List<E> findAll(Class<E> e, String query);

    List<E> findAll(Class<E> e, String query, Predicate<E> predicate);

    List<S> findAll(Class<E> e, String query, Function<E, S> function);

}
