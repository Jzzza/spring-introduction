package com.springinaction.dataservice;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSpitterDAO implements SpitterDAO{
    private static final String SQL_INSERT_SPITTER = "update";
    private static final String SQL_SELECT_SPITTER_BY_ID = "select";
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

    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_ID, // Запрос на получение данных
                new ParameterizedRowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                        Spitter spitter = new Spitter();  // Отображение
                        spitter.setId(resultSet.getLong(1));
                        spitter.setUsername(resultSet.getString(2));
                        spitter.setPassword(resultSet.getString(3));
                        spitter.setFullName(resultSet.getString(4));
                        return spitter;
                    }
                },
            id
        );
    }
}
