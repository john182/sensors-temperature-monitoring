package com.chronos.sensors.temperature.monitoring.api.controller.responses;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class TemperatureLogResponse {
    private UUID id;
    private UUID sensorId;
    private OffsetDateTime registeredAt;
    private Double value;
}
