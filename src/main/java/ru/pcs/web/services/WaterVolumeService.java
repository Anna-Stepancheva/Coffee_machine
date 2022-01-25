package ru.pcs.web.services;

import ru.pcs.web.models.WaterVolume;

import java.util.List;

public interface WaterVolumeService {
    void add(int volume);
    void delete(int waterVolumeId);
    void update(int waterVolumeId, int volume);
    List<WaterVolume> getAllWaterVolume();
}
