package DAO;

import model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
    //1. Создание(добавление) сущности Employee в таблицу
    //2. Получение конкретного объекта Employee по id
    //3. Получение списка всех объектов Employee из базы
    //4. Изменение конкретного объекта Employee в базе по id
    //5. Удаление конкретного объекта Employee из базы по id
    void create (Employee employee) throws SQLException;
    Employee getById (Integer id) throws SQLException;
    ArrayList<Employee> getAll () throws SQLException;
    void updateById(Integer id, Employee employee) throws SQLException;
    void removeById (Integer id) throws SQLException;
}
