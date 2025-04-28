package com.chronos.sensors.temperature.monitoring.domain.repository;

import com.chronos.sensors.temperature.monitoring.domain.model.SensorMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorMonitoringRepository extends JpaRepository<SensorMonitoring, UUID> {
}
