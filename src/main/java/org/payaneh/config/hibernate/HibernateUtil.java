package org.payaneh.config.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static SessionFactory sessionFactory;

    public SessionFactory getInstance() {
        if (sessionFactory==null)
            sessionFactory=new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
