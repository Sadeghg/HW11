package template.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E, PK extends Serializable>{

    void save(E e);

    void update(E e);

    E findById(Class<E> e, PK id);

    void delete(Class<E> e, PK id);

    List<E> findAll(Class<E> e);

}
