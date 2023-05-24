import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employees = new EmployeeDAOImpl();

        Employee employee = new Employee();
        employee.setFirstname("first_name");
        employee.setLastName("last_name");
        employee.setGender("m");
        employee.setAge(3);
        employee.setCityId(3);

        System.out.println(employees.getAll());
        System.out.println(employees.getById(5));
        employees.create(employee);
        employee.setAge(80);
        employees.update(employee);
        employees.removeById(15);
        System.out.println(employees.getAll());



    }
}
