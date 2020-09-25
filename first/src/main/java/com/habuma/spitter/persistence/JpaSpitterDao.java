package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.SpitterDAO;
import com.habuma.spitter.domain.Spittle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// @Repository("spitterDao")                                           // Использование контекстных сеансов в hibernate
@Transactional                                                      // Выполнение методово проиходит в контексте транзакции
public class JpaSpitterDao implements SpitterDAO {
    private static final String RECENT_SPITTLES = "SELECT s from Spittle s";
    private static final String ALL_SPITTERS = "SELECT s FROM Spitter s";
    private static final String SPITTER_FOR_USERNAME = "SELECT s FROM Spitter s WHERE s.username = :username";
    private static final String SPITTLES_BY_USERNAME = "SELECT s FROM Spittle s WHERE s.spitter.username = :username";

    @PersistenceContext                                             // Явно должно быть внедрено в EntityManager
    private EntityManager em;                                       // Для внедрения EntityManager

    public void addSpitter(Spitter spitter) {
        em.persist(spitter);                                        // Использование EntityManager
    }

    public Spitter getSpitterById(long id){
        return em.find(Spitter.class, id);                          // Использование EntityManager
    }

    public void saveSpitter(Spitter spitter){
        em.merge(spitter);                                          // Использование EntityManager
    }
}
