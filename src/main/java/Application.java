import DAO.CityDAO;
import DAO.CityDAOImpl;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employees = new EmployeeDAOImpl();
        CityDAO cities  = new CityDAOImpl();


        Employee e1 = new Employee();
        e1.setFirstname("Peter");
        e1.setLastName("Petrov");
        e1.setAge(8);
        e1.setGender("m");

        Employee e2 = new Employee();
        e2.setFirstname("Ivan");
        e2.setLastName("Ivanov");
        e2.setAge(54);
        e2.setGender("m");

        City city = new City();
        city.setCityName("Paris");
        city.setEmployees(new ArrayList<Employee>(Arrays.asList(e1, e2)));

        cities.create(city);
        System.out.println(city);


        City c = cities.getById(8);

        e1.setCity(c);
        e2.setCity(c);
        employees.update(e1);
        employees.update(e2);


        cities.removeById(8);


    }
}
