package src.by.fpmibsu.pizzaweb.Dao;

import src.by.fpmibsu.pizzaweb.Entity.Address;

import java.util.List;

public interface AddressDao extends BaseDao<Long, Address> {
    List<Address> findAllByStreet(String pattern);
}
