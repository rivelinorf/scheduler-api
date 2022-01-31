package io.prosper.schedulerapi.adpaters.inbound.dto.response;

import io.prosper.schedulerapi.application.model.Schedule;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Builder
@Data
public class ScheduleResponse {
    private String id;
    private String objectUUID;
    private String tenantUUID;
    private Long duration;
    private Long startAt;
    private Long finishAt;
    private Long executedAt;
    private String type;
    private String version;

    public static ScheduleResponse of(Schedule schedule) {
        ScheduleResponse response = builder().build();
        BeanUtils.copyProperties(response, response);
        return response;
    }
}
