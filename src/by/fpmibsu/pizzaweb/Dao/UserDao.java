package src.by.fpmibsu.pizzaweb.Dao;

import src.by.fpmibsu.pizzaweb.Entity.User;

public interface UserDao extends BaseDao<Long, User>{
    User findByName(String string);
}
