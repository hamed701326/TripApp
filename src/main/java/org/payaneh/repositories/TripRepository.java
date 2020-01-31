package org.payaneh.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.payaneh.config.hibernate.CrudRepository;
import org.payaneh.config.hibernate.HibernateUtil;
import org.payaneh.entities.Trip;

import java.util.Date;
import java.util.List;

public class TripRepository extends CrudRepository<Trip, Integer> {
    private static TripRepository tripRepo=new TripRepository();
    private TripRepository()
    { }
    public static TripRepository getTripRepo()
    {
        return tripRepo;
    }

    @Override
    protected Class<Trip> getEntityClass()
    {
        return Trip.class;
    }

    @Override
    protected SessionFactory getSessionFactory()
    {
        return HibernateUtil.getInstance();
    }

    public List<Trip> findAll(String origin,
                              String destination,
                              String date)
    {
        Session session=getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from Trip T " +
                "where T.origin=?1 " +
                "and T.destination=?2 and T.tripDate=?3");
        query.setParameter(1,origin).setParameter(2,destination)
                .setParameter(3,date);

        List<Trip> trips=query.list();
        session.getTransaction().commit();
        session.close();
        return trips;
    }
}
