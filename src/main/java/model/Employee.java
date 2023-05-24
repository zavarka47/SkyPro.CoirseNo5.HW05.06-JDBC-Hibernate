package model;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table (name= "employee")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "first_name")
    private String firstname;
    @Column (name = "last_name")
    private String lastName;
    private String gender;
    private Integer age;
    @Column (name = "city_id")
    private Integer cityId;
}
