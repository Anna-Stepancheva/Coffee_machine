package ru.pcs.web.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.models.Command;
import ru.pcs.web.repositories.CommandRepository;

@RequiredArgsConstructor
@Component
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CommandRepository commandRepository;

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
    public void work() {
        Command command = new Command();
        command.setCommand("Варим кофе...готово!");
        commandRepository.save(command);
    }
}
