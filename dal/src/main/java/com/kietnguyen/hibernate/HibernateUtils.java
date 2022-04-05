package com.kietnguyen.hibernate;

import com.kietnguyen.models.Owner;
import com.kietnguyen.models.Cat;
import com.kietnguyen.models.CatAndFriend;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Owner.class);
        conf.addAnnotatedClass(Cat.class);
        conf.addAnnotatedClass(CatAndFriend.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

}
