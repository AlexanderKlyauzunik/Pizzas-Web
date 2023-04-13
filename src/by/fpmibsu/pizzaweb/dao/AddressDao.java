package src.by.fpmibsu.pizzaweb.dao;

import src.by.fpmibsu.pizzaweb.entity.Address;

import java.util.List;

public interface AddressDao extends BaseDao<Long, Address> {
    List<Address> findAllByStreet(String pattern);
}
