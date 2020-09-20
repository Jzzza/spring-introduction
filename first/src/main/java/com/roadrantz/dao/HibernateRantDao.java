package com.roadrantz.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Date;
import java.util.List;

public class HibernateRantDao extends HibernateDaoSupport {
    private String RANT;

    public List<Rant> getRantsForDay(Date day){
        return getHibernateTemplate().find("from " + RANT +
                " where postedDate = ?", day);
    }
}