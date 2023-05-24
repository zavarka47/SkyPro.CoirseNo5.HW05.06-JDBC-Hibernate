package model;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data

public class City {
    private Integer cityId;
    private String cityName;


    static void createCity (ResultSet resultSet) throws SQLException {
        City city = new City();

        city.setCityId(resultSet.getInt("city_id"));
        city.setCityName(resultSet.getString("city_name"));
    }


}
