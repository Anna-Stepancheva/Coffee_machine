package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Coffee;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}