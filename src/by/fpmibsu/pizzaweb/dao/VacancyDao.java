package src.by.fpmibsu.pizzaweb.dao;

<<<<<<< HEAD:src/by/fpmibsu/pizzaweb/Dao/VacancyDao.java
import src.by.fpmibsu.pizzaweb.Entity.User;
import src.by.fpmibsu.pizzaweb.Entity.Vacancy;
=======
import src.by.fpmibsu.pizzaweb.entity.Vacancy;
>>>>>>> parent of 09c05fd... Rename some packages and classes:src/by/fpmibsu/pizzaweb/dao/VacancyDao.java

import java.util.List;

public interface VacancyDao extends BaseDao<Long, Vacancy> {
    List<Vacancy> findByTitle(String pattern);

    void AddToMMUserVacancy(Long userId, Long vacancyId);
}
