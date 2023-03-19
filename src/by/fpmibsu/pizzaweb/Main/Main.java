package src.by.fpmibsu.pizzaweb.Main;
import  src.by.fpmibsu.pizzaweb.entity.Address;

import java.sql.*;

public class Main {
        static final String DB_URL = "jdbc:postgresql://localhost:5432/Pizza-web";
        static final String USER = "Teamlead";
        static final String PASS = "password";

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM public.\"Address\"";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    long id = resultSet.getInt(1);
                    String street = resultSet.getString(2);
                    int corpse = resultSet.getInt(3);
                    int flatNumber = resultSet.getInt(4);
                    int houseNumber = resultSet.getInt(5);
                    Address address = new Address(id, street, houseNumber, corpse, flatNumber);
                    System.out.println(address);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
