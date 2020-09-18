package com.habuma.spitter.domain;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcSpitterDAO extends SimpleJdbcDaoSupport implements SpitterDAO{
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname) " +
            "values (:username, :password, :fullname)";
    private static final String SQL_SELECT_SPITTER_BY_ID = "select";

    public void addSpiiter(Spitter spitter) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", spitter.getUsername());
        params.put("password", spitter.getPassword());
        params.put("fullname", spitter.getFullName());

        getSimpleJdbcTemplate().update(SQL_INSERT_SPITTER, params);
        spitter.setId(queryForIdentity());
    }

    private long queryForIdentity() {
        return 0;
    }

    public Spitter getSpitterById(long id) {
        return getSimpleJdbcTemplate().queryForObject(SQL_SELECT_SPITTER_BY_ID, // Запрос на получение данных
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
