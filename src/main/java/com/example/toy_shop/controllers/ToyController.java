package com.example.toy_shop.controllers;

import com.example.toy_shop.model.Toy;
import com.example.toy_shop.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToyController {
    private final ToyService toyService;

    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @PostMapping("/addtoy")
    public String addToy(@RequestBody Toy toy) {
        toyService.addToy(toy);
        return "toy: " + toy + "added.";
    }

    @PostMapping("/getall")
    public List<Toy> getAll() {
        return toyService.getAll();
    }

    @PostMapping("/getrandomtoy")
    public Toy getRandomToy() {
        return toyService.getRandomToy();
    }
}
