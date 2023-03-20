package src.by.fpmibsu.pizzaweb.service;

import src.by.fpmibsu.pizzaweb.bl.Util;
import src.by.fpmibsu.pizzaweb.dao.AddressDao;
import src.by.fpmibsu.pizzaweb.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressService extends Util implements AddressDao {
     Connection connection = getConnection();

    private static final String SQL_CREATE_ADDRESS = "INSERT INTO public.\"Address\"(\n" +
            "\t\"AddressID\", \"Street\", \"Entrance\", \"HouseNumber\", \"FlatNumber\")\n" +
            "\tVALUES (?, ?, ?, ?, ?);";
    private static final String SQL_SELECT_ALL = "SELECT \"AddressID\", \"Street\", \"Entrance\", \"HouseNumber\", \"FlatNumber\"\n" +
            "\tFROM public.\"Address\";";
    public List<Address> findAllByStreet(String pattern) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addressList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Address address = new Address();
                address.setAddressID(resultSet.getLong("AddressID"));
                address.setStreet(resultSet.getString("Street"));
                address.setEntrance(resultSet.getInt("Entrance"));
                address.setHouseNumber(resultSet.getInt("HouseNumber"));
                address.setFlatNumber(resultSet.getInt("FlatNumber"));

                addressList.add(address);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(statement);
            close(connection);
        }
        return addressList;
    }

    @Override
    public Address findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Address address) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Address address) {
        PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQL_CREATE_ADDRESS);
                preparedStatement.setLong(1,address.getAddressID());
                preparedStatement.setString(2,address.getStreet());
                preparedStatement.setInt(3,address.getEntrance());
                preparedStatement.setInt(4,address.getFlatNumber());
                preparedStatement.setInt(5,address.getHouseNumber());

                preparedStatement.executeUpdate();
                return true;
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            finally {
                close(preparedStatement);
                close(connection);
            }
            return false;
    }

    @Override
    public void update(Address address) {

    }
}
