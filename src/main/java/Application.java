import DAO.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String username ="postgres";
        final String password = "[SunOmu66]";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(
                "SELECT employee.first_name, employee.last_name, employee.age, city.city_name" +
                        " FROM employee " +
                        "inner join city on employee.city_id = city.city_id" +
                        " WHERE employee.id = (?)" );

        statement.setInt(1, 6);

        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println("first_name: " + resultSet.getString("first_name") +
                    "; last_name: " + resultSet.getString("last_name") +
                    "; age: " + resultSet.getInt("age") +
                    "; city: " + resultSet.getString("city_name") + ";");
        }

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(connection);

        System.out.println(employeeDAO.getById(6));
        System.out.println(employeeDAO.getAll());
        employeeDAO.removeById(14);
        employeeDAO.create(employeeDAO.getById(3));
        employeeDAO.updateById(15, employeeDAO.getById(2));
        System.out.println(employeeDAO.getById(7));


    }
}
