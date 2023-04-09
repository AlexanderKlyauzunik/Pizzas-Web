package src.by.fpmibsu.pizzaweb.Dao;

import src.by.fpmibsu.pizzaweb.Entity.Pizza;

import java.util.List;

public interface PizzaDao extends BaseDao<Long, Pizza>{
    List<Pizza> findInRange (Double lowerBound, Double upperBound);
}
