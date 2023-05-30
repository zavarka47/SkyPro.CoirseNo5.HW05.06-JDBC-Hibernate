package model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "city_Id" )
    private City city;
}
