package com.example.toy_shop.dao;

import com.example.toy_shop.model.Toy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ToyDaoImpl implements ToyDao {

    private final JdbcTemplate jdbcTemplate;

    public ToyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addToy(Toy toy) {
        jdbcTemplate.update("INSERT INTO toyshop.toy (name, weight) VALUES (?, ?)", toy.getName(), toy.getWeight());
    }

    @Override
    public List<Toy> getAll() {
        return jdbcTemplate.query("SELECT * FROM toyshop.toy", (rs, rowNum) -> new Toy(rs.getLong("id"), rs.getString("name"), rs.getInt("weight")));
    }

    @Override
    public void deleteToy(long id) {
        jdbcTemplate.update("DELETE FROM toyshop.toy WHERE id = ?", id);
    }
}
