
package com.habuma.spitter.persistence;

import java.util.List;

import com.habuma.spitter.domain.SpitterDAO;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

@Repository                                                                             // Стереотипная аннотация, обнаруживаемая <context:component-scan>
public class HibernateSpitterDao implements SpitterDAO {                                // Также позволяет уменьшить размер XML конфигурации
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;                                           // Конструирует DAO
    }

    private Session currentSession(){                                                   // Извлекает текущий
        return sessionFactory.getCurrentSession();                                      // сеанс из фабрики
}                                                                                       // SessionFactory

    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);                                                 // Использует текущий сеанс
    }

    public Spitter getSpitterById(long id) {                                            // Использует текущий сеанс
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);                                               // Использует текущий сеанс
    }
}
