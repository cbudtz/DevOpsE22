package service;

import data.HibernateController;
import data.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("users")
@Log
public class UserService {
    private static final SessionFactory sessionFactory = new HibernateController("pgtest-db.4a4b.dk:6543/pg").getSessionFactory();

    @POST
    public Response createUser(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        return Response.ok(user.getId()).build();
    }
    @GET
    public List<User> getUsers(){
        Session session = sessionFactory.openSession();
        JpaCriteriaQuery<User> query = session.getCriteriaBuilder().createQuery(User.class);
        log.info("Getting users");
        query.from(User.class);
        List<User> data = session.createQuery(query).getResultList();
        return data;
    }
}