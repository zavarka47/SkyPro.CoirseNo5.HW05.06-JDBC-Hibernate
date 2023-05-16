package model;

import lombok.Data;

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


        employee.setId(resultSet.getInt("id"));
        employee.setFirstname(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setGender(resultSet.getString("gender"));
        employee.setAge(resultSet.getInt("age"));
        employee.setCityId(resultSet.getInt("city_id"));


        return employee;
    }

    public void setId(Integer id) {
        if (id == null){
            id = 0;
        } else {
            this.id = id;
        }
    }

    public void setAge(Integer age) {
        if (age == null){
            age = 0;
        } else {
            this.age = age;
        }
    }

    public void setCityId(Integer cityId) {

        this.cityId = cityId;
    }
}
