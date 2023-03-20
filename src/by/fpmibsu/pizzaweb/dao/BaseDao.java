package src.by.fpmibsu.pizzaweb.dao;
import src.by.fpmibsu.pizzaweb.entity.Entity;

import java.util.List;

public interface BaseDao <K, T extends Entity>{
    List<T> findAll();
    T findEntityById(K id);
    boolean delete(T t);
    boolean delete(K id);
    boolean create(T t);
    void update(T t);

}
