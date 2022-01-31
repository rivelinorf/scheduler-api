package io.prosper.schedulerapi.application.service;

import io.prosper.schedulerapi.adpaters.outbound.gcp.GCPScheduler;
import io.prosper.schedulerapi.application.model.Schedule;
import io.prosper.schedulerapi.application.port.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final GCPScheduler scheduler;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        schedule.setId(UUID.randomUUID().toString());
        return scheduler.create(schedule);
    }
}
