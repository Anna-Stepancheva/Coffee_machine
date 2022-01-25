package ru.pcs.web.services;

public interface CoffeeMachineService {

    void on();

    void off();

    void work(Integer coffeeId, Integer waterVolumeId);
}
