package com.juchnicki.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Rafal on 2016-10-09.
 */
@Repository
public class LocationHibernateDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(LocationHibernate location) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(location);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("There was an Exception during transaction commit : " + e.toString());
            System.out.println("Rollback performed.");
            session.getTransaction().rollback();
        }

    }

    public LocationPojo getLocation(int locationId) {
        /* To be implemented later ;p */
        return null;
    }
}
