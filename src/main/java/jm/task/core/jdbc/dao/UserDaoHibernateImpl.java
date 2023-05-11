package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;



public class UserDaoHibernateImpl implements UserDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(200), lastName VARCHAR(200), age INTEGER)";
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User userNew = new User(name, lastName, age);
        session.save(userNew);
        transaction.commit();
        session.close();

    }

    @Override
    public void removeUserById(long id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User userDel = session.load(User.class, id);
        session.delete(userDel);
        transaction.commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = new ArrayList<>();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> resultList = session.createQuery(query).getResultList();
        users.addAll(resultList);
        transaction.commit();
        session.close();

        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String clean = "DELETE FROM User";
        Query query = session.createQuery(clean);
        query.executeUpdate();

        transaction.commit();
        session.close();

    }
}
