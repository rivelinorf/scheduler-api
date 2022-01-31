package io.prosper.schedulerapi.adpaters.outbound.gcp;

import io.prosper.schedulerapi.application.model.Schedule;

public interface GCPScheduler {

    Schedule create(Schedule schedule);
}
