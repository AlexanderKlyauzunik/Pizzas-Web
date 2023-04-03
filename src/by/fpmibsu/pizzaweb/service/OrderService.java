package src.by.fpmibsu.pizzaweb.service;

import src.by.fpmibsu.pizzaweb.bl.Util;
import src.by.fpmibsu.pizzaweb.dao.OrderDao;
import src.by.fpmibsu.pizzaweb.entity.Order;
import src.by.fpmibsu.pizzaweb.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OrderService extends Util implements OrderDao {
    Connection connection = getConnection();
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Order order) {
        return false;
    }

    @Override
    public void update(Order order) {

    }
}
