package io.prosper.schedulerapi.application.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Schedule {

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
