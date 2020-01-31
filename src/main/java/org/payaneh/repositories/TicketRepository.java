package org.payaneh.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.payaneh.config.hibernate.CrudRepository;
import org.payaneh.config.hibernate.HibernateUtil;
import org.payaneh.entities.Ticket;

public class TicketRepository extends CrudRepository<Ticket,Integer> {
    private static TicketRepository ticketRep;
    private TicketRepository(){}

    @Override
    protected Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return HibernateUtil.getInstance();
    }


    public static TicketRepository getTicketRep() {
        if(ticketRep==null)
            ticketRep=new TicketRepository();
        return ticketRep;
    }
}
