package com.kietnguyen.hibernate;

import com.kietnguyen.models.CatAndFriend;
import org.hibernate.Session;

import java.text.ParseException;



public class HibernateTester {
    public static void main(String[] args) throws ParseException {
        Session session = HibernateUtils.getFACTORY().openSession();

        CatAndFriend caf = new CatAndFriend();

//        caf.setId(20);
//        caf.setIdOfFriend(17);

//        session.save(caf);

        session.close();
    }
}
