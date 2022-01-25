package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.models.Coffee;
import ru.pcs.web.repositories.CoffeeRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Override
    public void add(String coffeeName) {
        Coffee coffee = Coffee.builder()
                .name(coffeeName)
                .build();
        coffeeRepository.save(coffee);
    }

    @Override
    public void delete(int coffeeId) {
        coffeeRepository.deleteById(coffeeId);
    }

    @Override
    public void update(int coffeeId, String coffeeName) {
        Coffee coffee = coffeeRepository.getById(coffeeId);
        coffee.setName(coffeeName);
        coffeeRepository.save(coffee);
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }
}
