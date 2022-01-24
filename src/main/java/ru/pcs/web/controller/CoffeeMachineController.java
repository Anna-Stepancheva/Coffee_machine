package ru.pcs.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pcs.web.services.CoffeeMachineService;

@RestController
@RequestMapping("/coffee-machine/commands")
public class CoffeeMachineController {

    private final CoffeeMachineService coffeeMachineService;

    @Autowired
    public CoffeeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }

    @PostMapping("/on")
    @ApiOperation("Включение кофеварки")
    public void on(){
        coffeeMachineService.on();
    }

    @PostMapping("/off")
    @ApiOperation("Выключение кофеварки")
    public void off(){
        coffeeMachineService.off();
    }

    @PostMapping("/work")
    @ApiOperation("Команда варить кофе")
    public void work(){
        coffeeMachineService.work();
    }
}
