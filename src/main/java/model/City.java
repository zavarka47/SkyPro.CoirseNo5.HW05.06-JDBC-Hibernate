package model;

import lombok.Data;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Data

@Entity
public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "city_id")
    private Integer cityId;
    @Column (name = "city_name")
    private String cityName;
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
    private List<Employee> employees;

}
