package DAO;

import model.City;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {

    void create (City city) throws SQLException;
    City getById (Integer id) throws SQLException;
    List<City> getAll () throws SQLException;
    void update(City city) throws SQLException;
    void removeById (Integer id) throws SQLException;
}
