package ru.pcs.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.models.Coffee;
import ru.pcs.web.services.CoffeeService;

import java.util.List;

@RestController
@RequestMapping("/coffee-machine/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    @ApiOperation("Посмотреть все доступные виды кофе")
    public String getListOfCoffee(Model model){
        List<Coffee> coffeeList = coffeeService.getAllCoffee();
        model.addAttribute("coffee", coffeeList);
        return "coffee";
    }

    @PostMapping
    @ApiOperation("Добавить вид кофе")
    public String addCoffee(String coffeeName){
        coffeeService.add(coffeeName);
        return "redirect:/coffee";
    }

    @DeleteMapping("/{coffee-id}/delete")
    @ApiOperation("Удалить кофе")
    public String deleteCoffee(@PathVariable("coffee-id") int coffeeId){
        coffeeService.delete(coffeeId);
        return "redirect:/coffee";
    }

    @PostMapping("/{coffee-id}/update")
    @ApiOperation("Обновить информацию о кофе")
    public String updateCoffee(@PathVariable("coffee-id") int coffeeId,String coffeeName){
        coffeeService.update(coffeeId,coffeeName);
        return "redirect:/coffee";
    }
}
