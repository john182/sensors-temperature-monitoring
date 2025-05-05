package com.chronos.sensors.temperature.monitoring.api.controller;

import com.chronos.sensors.temperature.monitoring.api.controller.responses.TemperatureLogResponse;
import com.chronos.sensors.temperature.monitoring.domain.model.TemperatureLog;
import com.chronos.sensors.temperature.monitoring.domain.repository.TemperatureLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures")
@RequiredArgsConstructor
public class TemperatureLogController {
    
    private final TemperatureLogRepository temperatureLogRepository;

    @GetMapping
    public Page<TemperatureLogResponse> search(@PathVariable UUID sensorId,
                                               @PageableDefault Pageable pageable) {
        Page<TemperatureLog> temperatureLogs = temperatureLogRepository.findAllBySensorId(sensorId, pageable);

        return temperatureLogs.map(temperatureLog ->
                TemperatureLogResponse.builder()
                        .id(temperatureLog.getId())
                        .value(temperatureLog.getValue())
                        .registeredAt(temperatureLog.getRegisteredAt())
                        .sensorId(temperatureLog.getSensorId())
                        .build());
    }

}
