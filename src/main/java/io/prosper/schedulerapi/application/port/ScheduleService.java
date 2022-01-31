package io.prosper.schedulerapi.application.port;

import io.prosper.schedulerapi.application.model.Schedule;

public interface ScheduleService {

    Schedule createSchedule(Schedule schedule);
}
