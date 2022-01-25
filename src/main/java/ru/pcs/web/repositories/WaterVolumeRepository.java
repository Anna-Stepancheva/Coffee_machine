package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.WaterVolume;

public interface WaterVolumeRepository extends JpaRepository<WaterVolume, Integer> {
}
