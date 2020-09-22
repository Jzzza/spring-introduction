package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.JpaSpitterDao;

public class SpitterServiceImpl {
    JpaSpitterDao spitterDao;

    public void saveSpitter(Spitter spittle) {
        spitterDao.saveSpitter(spittle);
    }
}
