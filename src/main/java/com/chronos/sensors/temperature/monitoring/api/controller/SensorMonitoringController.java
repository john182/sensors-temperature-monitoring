package com.chronos.sensors.temperature.monitoring.api.controller;

import com.chronos.sensors.temperature.monitoring.api.controller.responses.SensorMonitoringresponse;
import com.chronos.sensors.temperature.monitoring.domain.model.SensorMonitoring;
import com.chronos.sensors.temperature.monitoring.domain.repository.SensorMonitoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.UUID;

@RestController
@RequestMapping("/api/sensors/{sensorId}/monitoring")
@RequiredArgsConstructor
public class SensorMonitoringController {

    private final SensorMonitoringRepository sensorMonitoringRepository;

    @GetMapping
    public SensorMonitoringresponse getDetail(@PathVariable UUID sensorId) {
        SensorMonitoring sensorMonitoring = findByIdOrDefault(sensorId);

        return SensorMonitoringresponse.builder()
                .id(UUID.randomUUID())
                .enabled(sensorMonitoring.getEnabled())
                .lastTemperature(sensorMonitoring.getLastTemperature())
                .updatedAt(sensorMonitoring.getUpdatedAt())
                .build();
    }

    private SensorMonitoring findByIdOrDefault(UUID sensorId) {
        return sensorMonitoringRepository.findById(sensorId)
                .orElse(SensorMonitoring.builder()
                        .id(sensorId)
                        .enabled(false)
                        .lastTemperature(null)
                        .updatedAt(null)
                        .build());
    }

    @PutMapping("/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enable(@PathVariable UUID sensorId) {
        SensorMonitoring sensorMonitoring = findByIdOrDefault(sensorId);
        sensorMonitoring.setEnabled(true);
        sensorMonitoringRepository.saveAndFlush(sensorMonitoring);
    }

    @DeleteMapping("/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void disable(@PathVariable UUID sensorId) {
        SensorMonitoring sensorMonitoring = findByIdOrDefault(sensorId);
        sensorMonitoring.setEnabled(false);
        sensorMonitoringRepository.saveAndFlush(sensorMonitoring);
    }

}
