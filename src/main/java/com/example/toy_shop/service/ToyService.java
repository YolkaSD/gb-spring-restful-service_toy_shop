package com.example.toy_shop.service;

import com.example.toy_shop.model.Toy;

import java.util.List;

public interface ToyService {
    void addToy(Toy toy);

    List<Toy> getAll();

    Toy getRandomToy();

    void deleteToy(long id);
}
