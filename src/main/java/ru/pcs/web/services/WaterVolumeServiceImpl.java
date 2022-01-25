package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.models.WaterVolume;
import ru.pcs.web.repositories.WaterVolumeRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class WaterVolumeServiceImpl implements WaterVolumeService {

    private final WaterVolumeRepository waterVolumeRepository;

    @Override
    public void add(int volume) {
        WaterVolume waterVolume = WaterVolume.builder()
                .volume(volume)
                .build();
        waterVolumeRepository.save(waterVolume);
    }

    @Override
    public void delete(int waterVolumeId) {
        waterVolumeRepository.deleteById(waterVolumeId);
    }

    @Override
    public void update(int waterVolumeId, int volume) {
        WaterVolume waterVolume = waterVolumeRepository.getById(waterVolumeId);
        waterVolume.setVolume(volume);
        waterVolumeRepository.save(waterVolume);
    }

    @Override
    public List<WaterVolume> getAllWaterVolume() {
        return waterVolumeRepository.findAll();
    }
}
