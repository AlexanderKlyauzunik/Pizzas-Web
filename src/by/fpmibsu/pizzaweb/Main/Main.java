package src.by.fpmibsu.pizzaweb.Main;

import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.*;
import src.by.fpmibsu.pizzaweb.Entity.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Deque;
import java.util.List;

public class Main{
        public static void main(String[] args) {
            User user = new User(new AddressDaoImpl().findEntityById(5L),new OrderDaoImpl().findEntityById(1L),"Ivan Ivanov","fsf","dsvjdsbvj","+375",new RoleDaoImpl().findEntityById(2L));
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.create(user);
    }
}
