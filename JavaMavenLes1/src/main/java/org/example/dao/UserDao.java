package org.example.dao;

import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.utils.HibernateSessionfactoryUtil;

public class UserDao {
    public User findById(int id){
        Session session = HibernateSessionfactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void save(User user){
        Session session = HibernateSessionfactoryUtil.getSessionFactory().openSession();
        Transaction tx1= session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user){
        Session session = HibernateSessionfactoryUtil.getSessionFactory().openSession();
        Transaction tx1= session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user){
        Session session = HibernateSessionfactoryUtil.getSessionFactory().openSession();
        Transaction tx1= session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
