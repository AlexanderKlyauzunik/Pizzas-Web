package src.by.fpmibsu.pizzaweb.Dao.DaoImpl;

import src.by.fpmibsu.pizzaweb.Services.Util;
import src.by.fpmibsu.pizzaweb.Dao.UserDao;
import src.by.fpmibsu.pizzaweb.Entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends Util implements UserDao {
    Connection connection = getConnection();
    @Override
    public List<User> findAll() {
        final String SQL_SELECT_ALL = "SELECT \"UserID\", \"Role_id\", \"First_SecondName\", \"Password\", \"Email\", \"Phone_number\", \"Address_id\", \"Order_id\"\n" +
                "\tFROM public.\"User\";";

        List<User> users = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setRole(new RoleDaoImpl().findEntityById(resultSet.getLong("Role_id")));
                user.setFirstName_lastName(resultSet.getString("First_SecondName"));
                user.setPassword(resultSet.getString("Password"));
                user.setEmail(resultSet.getString("Email"));
                user.setTelephone(resultSet.getString("Phone_number"));
                user.setAddresses(new AddressDaoImpl().findEntityById(resultSet.getLong("Address_id")));
                user.setOrder(new OrderDaoImpl().findEntityById(resultSet.getLong("Order_id")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    @Override
    public User findEntityById(Long id) {
        PreparedStatement preparedStatement = null;
        User user = new User();
        final String SQL_SELECT_BY_ID = "SELECT \"UserID\", \"Role_id\", \"First_SecondName\", \"Password\", \"Email\", \"Phone_number\", \"Address_id\", \"Order_id\"\n" +
                "\tFROM public.\"User\" WHERE \"UserID\" = ?;";
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            user.setUserId(resultSet.getLong("UserID"));
            user.setRole(new RoleDaoImpl().findEntityById(resultSet.getLong("Role_id")));
            user.setFirstName_lastName(resultSet.getString("First_SecondName"));
            user.setPassword(resultSet.getString("Password"));
            user.setEmail(resultSet.getString("Email"));
            user.setTelephone(resultSet.getString("Phone_number"));
            user.setAddresses(new AddressDaoImpl().findEntityById(resultSet.getLong("Address_id")));
            user.setOrder(new OrderDaoImpl().findEntityById(resultSet.getLong("Order_id")));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
        return user;
    }

    @Override
    public boolean delete(User user) {
        final String SQL_DELETE_BY_ID = "DELETE FROM public.\"User\"\n" +
                "\tWHERE \"First_SecondName\" = ?;";
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setString(1,user.getFirstName_lastName());

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
        final String SQL_DELETE_BY_ID = "DELETE FROM public.\"User\"\n" +
                "\tWHERE \"UserID\" = ?;";
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
    public boolean create(User user) {
        final String SQL_CREATE_ADDRESS = "INSERT INTO public.\"User\"(\n" +
                "\t\"Role_id\", \"First_SecondName\", \"Password\", \"Email\", \"Phone_number\", \"Address_id\", \"Order_id\")\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_ADDRESS);
            preparedStatement.setLong(1,user.getRole().getId());
            preparedStatement.setString(2,user.getFirstName_lastName());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getTelephone());
            preparedStatement.setLong(6,user.getAddresses().getId());
            preparedStatement.setLong(7,user.getOrder().getId());

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
    public void update(User user) {
        final String SQL_UPDATE = "UPDATE public.\"User\"\n" +
                "\tSET \"Role_id\"=?, \"First_SecondName\"=?, \"Password\"=?, \"Email\"=?, \"Phone_number\"=?, \"Address_id\"=?, \"Order_id\"=?\n" +
                "\tWHERE \"UserID\" = ?;";

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setLong(1,user.getRole().getId());
            preparedStatement.setString(2,user.getFirstName_lastName());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getTelephone());
            preparedStatement.setLong(6,user.getAddresses().getId());
            preparedStatement.setLong(7,user.getOrder().getId());
            preparedStatement.setLong(8,user.getUserId());
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