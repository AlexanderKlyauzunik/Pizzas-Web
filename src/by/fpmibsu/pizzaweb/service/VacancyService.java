package src.by.fpmibsu.pizzaweb.service;

import src.by.fpmibsu.pizzaweb.bl.Util;
import src.by.fpmibsu.pizzaweb.dao.UserDao;
import src.by.fpmibsu.pizzaweb.dao.VacancyDao;
import src.by.fpmibsu.pizzaweb.entity.Role;
import src.by.fpmibsu.pizzaweb.entity.User;
import src.by.fpmibsu.pizzaweb.entity.Vacancy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
                Connection connection1 = getConnection();
                Statement statement1 = null;
                try {
                    statement1 = connection1.createStatement();

                    ResultSet resultSet1 = statement1.executeQuery(SQL_INNER);
                    List<User> users = new ArrayList<>();
                    while (resultSet1.next()) {
                      //  users.add(new Use())
                    }

                }
                catch (SQLException e){
                    e.printStackTrace();
                }
                finally {
                    close(statement1);
                    close(connection1);
                }
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
        return null;
    }

    @Override
    public boolean delete(Vacancy vacancy) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Vacancy vacancy) {
        return false;
    }

    @Override
    public void update(Vacancy vacancy) {

    }

    @Override
    public List<Vacancy> findByTitle(String pattern) {
        return null;
    }

    @Override
    public List<Vacancy> findBySalary(Double salary) {
        return null;
    }
}
