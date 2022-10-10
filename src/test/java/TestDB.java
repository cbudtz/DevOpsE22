import data.HibernateController;
import data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import service.GiraffeService;

import java.util.List;

public class TestDB {

    @Test
    public void testCreate(){
        HibernateController hibernateController =
                new HibernateController("pgtest-db.4a4b.dk:6543/pg");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        System.out.println("UserID before commit: " + user.getId());
        user.setUsername("Melman");
        session.persist(user);
        transaction.commit();
        System.out.println("UserID after commit: " + user.getId());
        Transaction readTransaction = session.beginTransaction();
        User readUser = session.get(User.class, user.getId());
        System.out.println("Read user back: " + readUser.toString());
        readTransaction.commit();
        session.close();
    }

    @Test
    public void getAllUsers(){
        List<User> giraffes = new GiraffeService().getGiraffes();
        System.out.println(giraffes);
    }
}
