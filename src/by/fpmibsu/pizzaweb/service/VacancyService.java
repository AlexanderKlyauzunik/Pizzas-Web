package src.by.fpmibsu.pizzaweb.service;

import src.by.fpmibsu.pizzaweb.bl.Util;
import src.by.fpmibsu.pizzaweb.dao.VacancyDao;
import src.by.fpmibsu.pizzaweb.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class VacancyService extends Util implements VacancyDao {
    Connection connection = getConnection();
    @Override
    public List<Vacancy> findAll() {
        final String SQL_SELECT_ALL = "SELECT \"VacancyID\", \"Salary\", \"Trial\", \"Name\"\n" +
                "\tFROM public.\"Vacancy\";";
        final String SQL_INNER = "SELECT \"UserID\"\n" +
                "\tFROM public.\"User_Vacancy\" WHERE \"VacancyID\" = ?;";
        List<Vacancy> vacancies = new ArrayList<>();


        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Vacancy vacancy = new Vacancy();
                vacancy.setVacancyID(resultSet.getLong("VacancyID"));
                vacancy.setSalary(resultSet.getDouble("Salary"));
                vacancy.setTrial(resultSet.getInt("Trial"));
                vacancy.setName(resultSet.getString("Name"));
                Statement statement1 = null;
                try {
                    statement1 = connection.createStatement();

                    ResultSet resultSet1 = statement1.executeQuery(SQL_INNER);
                    HashSet<User> users = new HashSet<>();
                    while (resultSet1.next()) {
                        users.add(new UserService().findEntityById(resultSet1.getLong("UserID")));
                    }
                    vacancy.setUser(users);
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
                finally {
                    close(statement1);
                }
                vacancies.add(vacancy);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(statement);
            close(connection);
        }
        return vacancies;
    }

    @Override
    public Vacancy findEntityById(Long id) {
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        Vacancy vacancy = new Vacancy();
        final String SQL_SELECT_BY_ID = "SELECT \"VacancyID\", \"Salary\", \"Trial\", \"Name\"\n" +
                "\tFROM public.\"Vacancy\" WHERE = ?;";

        final String SQL_INNER = "SELECT \"UserID\"\n" +
                "\tFROM public.\"User_Vacancy\" WHERE \"VacancyID\" = ?;";
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement1 = connection.prepareStatement(SQL_INNER);
            preparedStatement1.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            while (resultSet.next()) {
                vacancy.setId(resultSet.getLong("OrderID"));
                vacancy.setSalary(resultSet.getDouble("Salary"));
                vacancy.setTrial(resultSet.getInt("Trial"));
                vacancy.setName(resultSet.getString("Name"));

                HashSet<User> users = new HashSet<>();

<<<<<<< HEAD:src/by/fpmibsu/pizzaweb/Dao/DaoImpl/VacancyDaoImpl.java
                while (resultSet1.next())
                    users.add(new UserDaoImpl().findEntityById(resultSet1.getLong("UserID")));
=======
            while (resultSet1.next())
                users.add(new UserService().findEntityById(resultSet1.getLong("UserID")));
>>>>>>> parent of 09c05fd... Rename some packages and classes:src/by/fpmibsu/pizzaweb/service/VacancyService.java

                vacancy.setUser(users);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
        return vacancy;
    }

    @Override
    public boolean delete(Vacancy vacancy) {
        final String SQL_DELETE_BY_NAME = "DELETE FROM public.\"Vacancy\"\n" +
                "\tWHERE \"Name\" = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_NAME);
            preparedStatement.setString(1,vacancy.getName());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        final String SQL_DELETE_BY_ID = "DELETE FROM public.\"Vacancy\"\n" +
                "\tWHERE \"VacancyID\" = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }

    @Override
    public boolean create(Vacancy vacancy) {
        final String SQL_CREATE_ADDRESS = "INSERT INTO public.\"Vacancy\"(\n" +
                "\t\"Salary\", \"Trial\", \"Name\")\n" +
                "\tVALUES (?, ?, ?);";

        final String SQL_INNER = "INSERT INTO public.\"User_Vacancy\"(\n" +
                "\t\"VacancyID\", \"UserID\")\n" +
                "\tVALUES (?, ?);";

        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_ADDRESS);

            preparedStatement.setDouble(1,vacancy.getSalary());
            preparedStatement.setInt(2,vacancy.getTrial());
            preparedStatement.setString(3,vacancy.getName());

            HashSet<User> users = vacancy.getUser();
            preparedStatement.executeUpdate();
            Long index = this.getLastID();
            for (User user : users) {
                preparedStatement1 = connection.prepareStatement(SQL_INNER);
                preparedStatement1.setLong(1, vacancy.getId());
                preparedStatement1.setLong(2, index);
                preparedStatement1.executeUpdate();
            }

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
    public void update(Vacancy vacancy) {
        final String SQL_UPDATE = "UPDATE public.\"Vacancy\"\n" +
                "\tSET \"Salary\"=?, \"Trial\"=?, \"Name\"=?\n" +
                "\tWHERE \"VacancyID\" = ?;";

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setDouble(1,vacancy.getSalary());
            preparedStatement.setInt(2,vacancy.getTrial());
            preparedStatement.setString(3,vacancy.getName());
            preparedStatement.setLong(4,vacancy.getVacancyID());

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

    @Override
    public List<Vacancy> findByTitle(String pattern) {
        return null;
    }

    @Override
    public void AddToMMUserVacancy(Long userId, Long vacancyId) {
        final String SQL_LAST_ID = "INSERT INTO public.\"User_Vacancy\"(\n" +
                "\t\"VacancyID\", \"UserID\")\n" +
                "\tVALUES (?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_LAST_ID);
            preparedStatement.setLong(1,vacancyId);
            preparedStatement.setLong(2,userId);

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

    private Long getLastID () {
        final String SQL_LAST_ID = "SELECT \"UserID\"\n" +
                "\tFROM public.\"User\" ORDER BY \"UserID\" DESC LIMIT 1;";
        PreparedStatement preparedStatement = null;
        Long index = 0L;
        try{
            preparedStatement = connection.prepareStatement(SQL_LAST_ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                index = resultSet.getLong("OrderID");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
        }
        return index;
    }


}
