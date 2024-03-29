package src.by.fpmibsu.pizzaweb.Dao;

import src.by.fpmibsu.pizzaweb.Entity.User;
import src.by.fpmibsu.pizzaweb.Entity.Vacancy;

import java.util.List;

public interface VacancyDao extends BaseDao<Long, Vacancy> {
    List<Vacancy> findByTitle(String pattern);

    void AddToMMUserVacancy(Long userId, Long vacancyId);
}
