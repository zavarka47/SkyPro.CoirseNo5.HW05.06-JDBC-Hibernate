package DAO;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (first_name, last_name, gender, age, city_id ) " +
                        "VALUES ((?), (?), (?), (?), (?))");

        statement.setString(1, employee.getFirstname());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getGender());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getCityId());

        statement.executeUpdate();
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT employee.* , city.* FROM employee " +
                        "INNER JOIN city ON employee.city_id = city.city_id " +
                        "WHERE employee.id = ?");
        statement.setInt(1, id);
        statement.setMaxRows(1);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return Employee.createEmployee(resultSet);
    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(
                "SELECT employee.* , city.* FROM employee " +
                        "INNER JOIN city ON employee.city_id = city.city_id");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            employees.add(Employee.createEmployee(resultSet));
        }

        return employees;
    }

    @Override
    public void updateById(Integer id, Employee employee) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET " +
                        "(first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?)) " +
                        "WHERE id = (?)");

        statement.setString(1, employee.getFirstname());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getGender());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getCityId());
        statement.setInt(6, id);

        statement.executeUpdate();
    }

    @Override
    public void removeById(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
