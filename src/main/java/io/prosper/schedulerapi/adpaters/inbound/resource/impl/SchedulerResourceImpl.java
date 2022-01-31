package io.prosper.schedulerapi.adpaters.inbound.resource.impl;

import io.prosper.schedulerapi.adpaters.inbound.dto.request.ScheduleRequest;
import io.prosper.schedulerapi.adpaters.inbound.dto.request.SheduleFired;
import io.prosper.schedulerapi.adpaters.inbound.dto.response.ScheduleResponse;
import io.prosper.schedulerapi.application.port.ScheduleService;
import io.prosper.schedulerapi.adpaters.inbound.resource.SchedulerResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SchedulerResourceImpl implements SchedulerResource {

    private final ScheduleService scheduleService;

    @Override
    public ResponseEntity<ScheduleResponse> schedule(ScheduleRequest request) {
        return new ResponseEntity<>(ScheduleResponse.of(scheduleService.createSchedule(request.toSchedule())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> receive(SheduleFired request) {
        log.info("schedule fired: {}", request );
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<String> findAll() {
        return List.of("riva", "cvortex");
    }
}
