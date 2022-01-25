package ru.pcs.web.controller;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/{coffee-id}/{water-volume-id}/work")
    @ApiOperation("Сварить кофе определенного сорта и объема")
    public void work(@PathVariable("coffee-id") Integer coffeeId,
                     @PathVariable("water-volume-id") Integer waterVolumeId) {
        coffeeMachineService.work(coffeeId, waterVolumeId);
    }
}
