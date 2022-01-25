package ru.pcs.web.services;

import ru.pcs.web.models.Coffee;

import java.util.List;

public interface CoffeeService {
    void add(String coffeeName);
    void delete(int coffeeId);
    void update(int coffeeId, String coffeeName);

    List<Coffee> getAllCoffee();
}
