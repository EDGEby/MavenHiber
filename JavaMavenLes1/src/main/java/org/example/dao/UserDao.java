package org.example.dao;

import org.example.models.Auto;
import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.utils.HibernateSessionfactoryUtil;

import java.util.List;

public class UserDao {
    public User findById(int id){
        Session session = HibernateSessionfactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public Auto findAutoById(int id){
        Session session = null;
        Auto auto = null;
        try{
            session = HibernateSessionfactoryUtil.getSessionFactory().openSession();
            auto = session.get(Auto.class, id);
        }
        catch (Exception e){
            System.out.println("exception");
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return auto;
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

    public List<User> findAll(){
        Session session = null;
        List<User> users = null;
        try {
            session = HibernateSessionfactoryUtil.getSessionFactory().openSession();

            users = (List<User>) session.createQuery("From User").list();
        }
        catch (Exception e){
            System.out.println("exception");
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return users;
    }


}
