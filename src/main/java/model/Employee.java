package model;

import lombok.Data;
import org.postgresql.util.PSQLException;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Employee {
    private Integer id;
    private String firstname;
    private String lastName;
    private String gender;
    private Integer age;
    private Integer cityId;

    public static Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();


        try {
            employee.setId(resultSet.getInt("id"));
            employee.setFirstname(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setGender(resultSet.getString("gender"));
            employee.setAge(resultSet.getInt("age"));
            employee.setCityId(resultSet.getInt("city_id"));

        } catch (PSQLException e){
            System.out.println("Работник под данному id не найден");
        }
        return employee;


    }
}
