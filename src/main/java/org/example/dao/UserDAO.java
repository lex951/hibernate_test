package org.example.dao;

import org.example.model.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class UserDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public void saveUser(User user) {
        session.beginTransaction();
        session.persist(user); // SAVE
        session.getTransaction().commit();

    }

    public User getUser(long id) {
        return HibernateUtil.getSessionFactory().openSession().get(User.class, id); // LOAD
    }

    public void updateUser(long id, User updatedUser) {
        session.beginTransaction();
        User userToBeUpdated = session.get(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setAge(updatedUser.getAge());
        session.getTransaction().commit();
    }

    public void deleteUser(long id) {
        session.remove(session.get(User.class, id)); // DELETE
        session.getTransaction().commit();
    }

}
