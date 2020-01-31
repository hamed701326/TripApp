package org.payaneh.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.payaneh.config.hibernate.CrudRepository;
import org.payaneh.config.hibernate.HibernateUtil;
import org.payaneh.entities.User;

public class UserRepository extends CrudRepository<User,Integer> {
    private static UserRepository userRepository;
    private UserRepository(){}

    public static UserRepository getUserRepository() {
        if(userRepository==null)
            userRepository=new  UserRepository();
        return userRepository;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return HibernateUtil.getInstance();
    }


    public User valid(User user){
        User user1=load(user.getUserName(),"userName");
         if(user.getPassword().equals(user1.getPassword()))
             return user1;

         return null;
    }
}
