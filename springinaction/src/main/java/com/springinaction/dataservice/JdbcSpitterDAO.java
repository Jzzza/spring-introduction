package com.springinaction.dataservice;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class JdbcSpitterDAO implements SpitterDAO{
    private SimpleJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
