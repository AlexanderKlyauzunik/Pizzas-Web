package src.by.fpmibsu.pizzaweb.Main;

import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.AddressDaoImpl;
import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.DrinkDaoImpl;
import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.OrderDaoImpl;
import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.PizzaDaoImpl;
import src.by.fpmibsu.pizzaweb.Entity.Address;
import src.by.fpmibsu.pizzaweb.Entity.Drink;
import src.by.fpmibsu.pizzaweb.Entity.Order;
import src.by.fpmibsu.pizzaweb.Entity.Pizza;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Deque;
import java.util.List;

public class Main{
        public static void main(String[] args) {
            ArrayList<Drink> dr = new ArrayList<>();
            dr.add(new DrinkDaoImpl().findEntityById(2L));
            dr.add(new DrinkDaoImpl().findEntityById(7L));
            ArrayList<Pizza> pz = new ArrayList<>();
            pz.add(new PizzaDaoImpl().findEntityById(4L));
            pz.add(new PizzaDaoImpl().findEntityById(10L));
            pz.add(new PizzaDaoImpl().findEntityById(20L));
            Date date = Date.valueOf("2023-12-3");
            System.out.println(date);
            Order order = new Order(dr,pz,false,Date.valueOf("2023-12-3"),"cash");
            OrderDaoImpl orderDao = new OrderDaoImpl();

            orderDao.create(order);
    }
}
