package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;

public interface SpitterService {
    public void saveSpitter(final Spitter spitter);

    Object getRecentSpittles(int count);
}
