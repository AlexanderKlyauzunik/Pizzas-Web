package src.by.fpmibsu.pizzaweb.dao;

import src.by.fpmibsu.pizzaweb.entity.Vacancy;

import java.util.List;

public interface VacancyDao extends BaseDao<Long, Vacancy> {
    List<Vacancy> findByTitle(String pattern);
    List<Vacancy> findBySalary(Double salary);
}
