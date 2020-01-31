package org.payaneh.config.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private HibernateUtil(){}
    public static  SessionFactory getInstance() {
        if (sessionFactory==null)
            sessionFactory=new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
