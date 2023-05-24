package DAO;

import model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO {

    void create (Employee employee) throws SQLException;
    Employee getById (Integer id) throws SQLException;
    List<Employee> getAll () throws SQLException;
    void update(Employee employee) throws SQLException;
    void removeById (Integer id) throws SQLException;
}
