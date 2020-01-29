package org.payaneh.config.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class CrudRepository<Entity,Id extends Serializable> {
    private Session session;
    protected abstract Class<Entity> getEntityClass();
    protected abstract Session getSession();
    public Id save(Entity entity){
        getSession().beginTransaction();
       Id id = (Id)getSession().save(entity);
        getSession().getTransaction();
        return id;
    }
    public void update(Entity entity){
        getSession().beginTransaction();
        getSession().update(entity);
        getSession().getTransaction();
    }

    public Entity findById(Id id){
        getSession().beginTransaction();
        Entity entity = (Entity) getSession().load(getEntityClass().getName(), (Serializable) id);
        getSession().getTransaction();
        return entity;
    }

    public List<Entity> findAll(){
        getSession().beginTransaction();
        List<Entity> entities = (List<Entity>) getSession()
                .createQuery("from "+getEntityClass().getName());
        getSession().getTransaction();
        getSession().close();
        return entities;
    }

    public void remove(Entity entity){
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
        getSession().close();
    }

    public<Attribute> Entity load(Attribute valueAttribute,String nameAtribute){
        getSession().beginTransaction();
        Query<Entity> query =  getSession()
                .createQuery("from "+ getEntityClass().getName()+" where "+nameAtribute+"= ?1");
        query.setParameter(1,valueAttribute);
        Entity entity= (Entity) query.list().get(0);
        getSession().getTransaction();
        getSession().close();
        return entity;

    }
}
