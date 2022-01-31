package io.prosper.schedulerapi.adpaters.inbound.dto.request;

import io.prosper.schedulerapi.application.model.Schedule;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@Builder
public class ScheduleRequest {
    private String objectUUID;
    private String tenantUUID;
    private Long duration;
    private Long startAt;
    private Long finishAt;
    private Long executedAt;
    private String type;
    private String version;

    public Schedule toSchedule() {
        Schedule schedule = Schedule.builder().build();
        BeanUtils.copyProperties(this, schedule);
        return schedule;
    }

}
