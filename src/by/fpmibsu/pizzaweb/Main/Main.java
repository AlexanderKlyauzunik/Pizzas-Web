package src.by.fpmibsu.pizzaweb.Main;

import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.AddressDaoImpl;
import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.OrderDaoImpl;
import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.PizzaDaoImpl;
import src.by.fpmibsu.pizzaweb.Entity.Address;
import src.by.fpmibsu.pizzaweb.Entity.Order;
import src.by.fpmibsu.pizzaweb.Entity.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Main{
        public static void main(String[] args) {
            Order order = new OrderDaoImpl().findEntityById(1L);
            System.out.println(order);
    }
}
