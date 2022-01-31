package io.prosper.schedulerapi.adpaters.inbound.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SheduleFired {
    private String id;
    private String objectUUID;
    private String tenantUUID;
    private Long duration;
    private Long startAt;
    private Long finishAt;
    private Long executedAt;
    private String type;
    private String version;
}
