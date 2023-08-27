package com.example.toy_shop.service;

import com.example.toy_shop.dao.ToyDao;
import com.example.toy_shop.model.Toy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class ToyServiceImpl implements ToyService {
    private final ToyDao toyDao;

    public ToyServiceImpl(ToyDao toyDao) {
        this.toyDao = toyDao;
    }

    @Override
    public void addToy(Toy toy) {
        toyDao.addToy(toy);
    }

    @Override
    public List<Toy> getAll() {
        return toyDao.getAll();
    }

    @Override
    public Toy getRandomToy() {
        List<Toy> toys = getAll();
        int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
        int randomWeight = new Random().nextInt(totalWeight) + 1;
        for (Toy toy: toys) {
            randomWeight -= toy.getWeight();
            if (randomWeight <= 0) {
                //deleteToy(toy.getId());
                return  toy;
            }
        }
        return null;
    }

    @Override
    public void deleteToy(long id) {
        toyDao.deleteToy(id);
    }
}
