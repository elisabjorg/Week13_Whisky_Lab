package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskyByYear(int year) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            //cr.createAlias("whiskies", "whiskyAlias" );
            cr.add(Restrictions.eq("year", year));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Whisky> findWhiskyByAgeInParticularDistillery(String name, int age) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.name", name));
//            cr.add(Restrictions.eq("age", age));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
