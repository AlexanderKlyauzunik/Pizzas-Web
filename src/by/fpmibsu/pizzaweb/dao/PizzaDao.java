package src.by.fpmibsu.pizzaweb.dao;

import src.by.fpmibsu.pizzaweb.entity.Pizza;

import java.util.List;

public interface PizzaDao extends BaseDao<Long, Pizza>{
    List<Pizza> findInRange (Double lowerBound, Double upperBound);

    Pizza findByNameTypeDroughSize (String name, Boolean typeDrough, Boolean size);
}
