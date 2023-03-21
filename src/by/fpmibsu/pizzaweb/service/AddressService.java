package src.by.fpmibsu.pizzaweb.service;

import src.by.fpmibsu.pizzaweb.bl.Util;
import src.by.fpmibsu.pizzaweb.dao.AddressDao;
import src.by.fpmibsu.pizzaweb.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressService extends Util implements AddressDao {
     Connection connection = getConnection();

    private static final String SQL_CREATE_ADDRESS = "INSERT INTO public.\"Address\"(\"AddressID\", \"Street\", \"Entrance\", \"HouseNumber\", \"FlatNumber\")\n" +
            "\tVALUES (?, ?, ?, ?, ?);";
    private static final String SQL_SELECT_ALL = "SELECT \"AddressID\", \"Street\", \"Entrance\", \"HouseNumber\", \"FlatNumber\" FROM public.\"Address\";";

    private static final String SQL_SELECT_BY_ID = "SELECT \"AddressID\", \"Street\", \"Entrance\", \"HouseNumber\", \"FlatNumber\" FROM public.\"Address\" \n" +
            "WHERE \"AddressID\" = ?;";

    private static final String SQL_UPDATE = "UPDATE public.\"Address\"\n" +
            "\tSET \"Street\"=?, \"Entrance\"=?, \"HouseNumber\"=?, \"FlatNumber\"=?\n" +
            "\tWHERE \"AddressID\"=?;";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM public.\"Address\"\n" +
            "\tWHERE \"AddressID\" = ?;";

    private static final String SQL_DELETE_BY_STREET = "DELETE FROM public.\"Address\"\n" +
            "\tWHERE \"Street\" = ?;";
    private static final String SQL_SELECT_BY_STREET = "SELECT \"AddressID\", \"Street\", \"Entrance\", \"HouseNumber\", \"FlatNumber\" FROM public.\"Address\" \n" +
            "WHERE \"Street\" = ?;";

    public List<Address> findAllByStreet(String pattern) {
        List<Address> addressList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_STREET);
            preparedStatement.setString(1,pattern);
            ResultSet resultSet = preparedStatement.executeQuery();

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
            close(preparedStatement);
            close(connection);
        }
        return addressList;
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
        PreparedStatement preparedStatement = null;
        Address address = new Address();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            address.setId(resultSet.getLong("AddressID"));
            address.setStreet(resultSet.getString("Street"));
            address.setEntrance(resultSet.getInt("Entrance"));
            address.setHouseNumber(resultSet.getInt("HouseNumber"));
            address.setFlatNumber(resultSet.getInt("FlatNumber"));

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
        return address;
    }

    @Override
    public boolean delete(Address address) {
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_STREET);
            preparedStatement.setString(1,address.getStreet());

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
    public boolean delete(Long id) {
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1,id);

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
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(1,address.getStreet());
            preparedStatement.setInt(2,address.getEntrance());
            preparedStatement.setInt(3,address.getFlatNumber());
            preparedStatement.setInt(4,address.getHouseNumber());
            preparedStatement.setLong(5,address.getAddressID());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
            close(connection);
        }

    }
}
