package ru.pcs.web.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.models.WaterVolume;
import ru.pcs.web.services.WaterVolumeService;

import java.util.List;

@RestController
@RequestMapping("/coffee-machine/water-volume")
public class WaterVolumeController {

    private final WaterVolumeService waterVolumeService;

    @Autowired
    public WaterVolumeController(WaterVolumeService waterVolumeService) {
        this.waterVolumeService = waterVolumeService;
    }

    @GetMapping
    @ApiOperation("Посмотреть весь доступный объем воды")
    public String getListOfWaterVolume(Model model){
        List<WaterVolume> waterVolumeList = waterVolumeService.getAllWaterVolume();
        model.addAttribute("waterVolume", waterVolumeList);
        return "water-volume";
    }

    @PostMapping
    @ApiOperation("Добавить объем воды")
    String addWaterVolume(int volume){
        waterVolumeService.add(volume);
        return "redirect:/water-volume";
    }

    @DeleteMapping("/{water-volume-id}/delete")
    @ApiOperation("Удалить объем воды")
    String deleteWaterVolume(@PathVariable("water-volume-id") int waterVolumeId){
        waterVolumeService.delete(waterVolumeId);
        return "redirect:/water-volume";
    }

    @PostMapping("/{water-volume-id}/update")
    @ApiOperation("Изменить запись об объеме воды")
    String updateWaterVolume(@PathVariable("water-volume-id") int waterVolumeId, int waterVolume){
        waterVolumeService.update(waterVolumeId, waterVolume);
        return "redirect:/water-volume";
    }
}
