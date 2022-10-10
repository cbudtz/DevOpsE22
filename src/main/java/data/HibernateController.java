package data;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateController {
    private final SessionFactory sessionFactory;

    public HibernateController(String dbUrl){
        Configuration configuration = new Configuration(); //NB org.hibernate.cfg.Configuration
        configuration.addAnnotatedClass(User.class); //remember to do this for all DB entities
        configuration.setProperty("hibernate.connection.username", System.getenv("devopse22user"));
        configuration.setProperty("hibernate.connection.password", System.getenv("devopse22pass"));
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://" + dbUrl);
        configuration.setProperty("hibernate.hbm2ddl.auto","update"); //Create Schema - potentially destroying data
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
