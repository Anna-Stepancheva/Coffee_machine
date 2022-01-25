package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.models.Command;
import ru.pcs.web.repositories.CoffeeRepository;
import ru.pcs.web.repositories.CommandRepository;
import ru.pcs.web.repositories.WaterVolumeRepository;

@RequiredArgsConstructor
@Component
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CommandRepository commandRepository;
    private final CoffeeRepository coffeeRepository;
    private final WaterVolumeRepository waterVolumeRepository;

    @Override
    public void on() {
        Command command = new Command();
        command.setCommand("Кофеварка включена.");
        commandRepository.save(command);
    }

    @Override
    public void off() {
        Command command = new Command();
        command.setCommand("Кофеварка выключена.");
        commandRepository.save(command);
    }

    @Override
    public void work(Integer coffeeId, Integer waterVolumeId) {
        Command command;

        if (coffeeRepository.existsById(coffeeId)
                & (waterVolumeRepository.existsById(waterVolumeId))) {
             command = Command.builder()
                    .command("Кофе сварено")
                    .coffeeId(coffeeId)
                    .waterVolumeId(waterVolumeId)
                    .build();
        } else{
             command = Command.builder()
                    .command("Ошибка при вводе данных")
                     .build();
        }
        commandRepository.save(command);
    }
}
