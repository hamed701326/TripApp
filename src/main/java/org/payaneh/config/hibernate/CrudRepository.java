package org.payaneh.config.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class CrudRepository<Entity,Id extends Serializable> {
    private Session session;
    protected abstract Class<Entity> getEntityClass();
    protected abstract SessionFactory getSessionFactory();
    public Id save(Entity entity){
        session=getSessionFactory().openSession();
        session.beginTransaction();
       Id id = (Id)session.save(entity);
        session.getTransaction().commit();
        session.close();
        return id;
    }
    public void save(List<Entity> entities){
        session=getSessionFactory().openSession();
        session.beginTransaction();
        entities.forEach(entity->session.save(entity));
        session.getTransaction().commit();
        session.close();
    }
    public void update(Entity entity){
        session=getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    public Entity findById(Id id){
        session=getSessionFactory().openSession();
        session.beginTransaction();
        Entity entity = (Entity) session.load(getEntityClass().getName(), (Serializable) id);
        session.getTransaction().commit();
        session.close();

        return entity;
    }

    public List<Entity> findAll(){
        session=getSessionFactory().openSession();
        session.beginTransaction();
        List<Entity> entities = (List<Entity>) session
                .createQuery("from "+getEntityClass().getName());
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    public void remove(Entity entity){
        session=getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }

    public<Attribute> Entity load(Attribute valueAttribute,String nameAtribute){
        session=getSessionFactory().openSession();
        session.beginTransaction();
        Query<Entity> query =  session
                .createQuery("from "+ getEntityClass().getName()+" where "+nameAtribute+"= ?1");
        query.setParameter(1,valueAttribute);
        Entity entity= (Entity) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return entity;

    }
}
