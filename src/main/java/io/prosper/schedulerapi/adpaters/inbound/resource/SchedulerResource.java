package io.prosper.schedulerapi.adpaters.inbound.resource;

import io.prosper.schedulerapi.adpaters.inbound.dto.request.ScheduleRequest;
import io.prosper.schedulerapi.adpaters.inbound.dto.request.SheduleFired;
import io.prosper.schedulerapi.adpaters.inbound.dto.response.ScheduleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedulers", produces = MediaType.APPLICATION_JSON_VALUE)
public interface SchedulerResource {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<ScheduleResponse> schedule(
            @RequestBody final ScheduleRequest request);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    ResponseEntity<Void> receive(
            @RequestBody final SheduleFired request);

    @GetMapping
    List<String> findAll();
}
