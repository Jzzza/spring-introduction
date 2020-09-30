package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.JpaSpitterDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SpitterServiceImpl implements SpitterService {
    JpaSpitterDao spitterDao;
    TransactionTemplate txTemplate;
    TransactionStatus txStatus;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveSpitter(final Spitter spitter) {
        // Чтобы исользовать класс TransactionTemplate нужно реализовать TransactionCallback
        txTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    spitterDao.saveSpitter(spitter);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        spitterDao.saveSpitter(spitter);
    }

    public Object getRecentSpittles(int count) {
        return null;
    }

    public Spitter getSpitter(String username) {
        return null;
    }

    public Object getSpittlesForSpitter(String username) {
        return null;
    }
}
