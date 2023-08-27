package com.example.toy_shop.dao;

import com.example.toy_shop.model.Toy;

import java.util.List;

public interface ToyDao {
    void addToy(Toy toy);

    List<Toy> getAll();

    void deleteToy(long id);
}
