package utils;

import model.City;
import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    public static SessionFactory getSessionFactory(){
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Employee.class)
                .addAnnotatedClass(City.class);
        return config.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
    }
}
