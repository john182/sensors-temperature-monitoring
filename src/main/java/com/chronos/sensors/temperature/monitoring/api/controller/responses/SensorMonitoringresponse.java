package com.chronos.sensors.temperature.monitoring.api.controller.responses;


import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class SensorMonitoringresponse {
    private UUID id;
    private Double lastTemperature;
    private OffsetDateTime updatedAt;
    private Boolean enabled;
}
