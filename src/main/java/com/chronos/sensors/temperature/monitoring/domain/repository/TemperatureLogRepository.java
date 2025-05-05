package com.chronos.sensors.temperature.monitoring.domain.repository;

import com.chronos.sensors.temperature.monitoring.domain.model.TemperatureLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemperatureLogRepository extends JpaRepository<TemperatureLog, UUID> {
    Page<TemperatureLog> findAllBySensorId(UUID sensorId, Pageable pageable);
}
