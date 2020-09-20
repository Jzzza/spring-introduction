package com.roadrantz.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springmodules.cache.annotations.CacheFlush;
import org.springmodules.cache.annotations.Cacheable;

import java.util.Date;
import java.util.List;

public class HibernateRantDao extends HibernateDaoSupport {
    private String RANT;

    // Cacheable отмечает метод, возвращаемое значение которого должно кешироваться
    @Cacheable(modelId = "rantzCacheModel")
    public List<Rant> getRantsForDay(Date day){
        return getHibernateTemplate().find("from " + RANT +
                " where postedDate = ?", day);
    }

    // При вызове метода происходит отчистка кеша
    @CacheFlush(modelId = "rantzFlushModel")
    public void saveRant(Rant rant) {
        getHibernateTemplate().saveOrUpdate(rant);
    }
}