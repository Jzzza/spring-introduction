package com.springinaction.dataservice;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class JdbcSpitterDAO implements SpitterDAO{
    private static final String SQL_INSERT_SPITTER = "update";
    private SimpleJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addSpiiter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.isUpdatedByEmail());
        spitter.isUpdatedByEmail();
    }
}
