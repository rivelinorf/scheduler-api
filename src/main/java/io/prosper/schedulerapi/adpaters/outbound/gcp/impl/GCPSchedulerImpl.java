package io.prosper.schedulerapi.adpaters.outbound.gcp.impl;

//import com.google.api.gax.core.FixedCredentialsProvider;
//import com.google.auth.Credentials;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.scheduler.v1.*;
//import com.google.protobuf.ByteString;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.scheduler.v1.*;
import com.google.protobuf.ByteString;
import io.prosper.schedulerapi.adpaters.outbound.gcp.GCPScheduler;
import io.prosper.schedulerapi.application.model.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class GCPSchedulerImpl implements GCPScheduler {

    static String projectId = "scheduler-api-339814";
    static String location = "southamerica-east1";

    static String trainingJobName = String.format("projects/%s/locations/%s/jobs/java_job", projectId, location);
    static String httpTargetUri = "https://4678-189-37-64-22.ngrok.io/schedulers";

    private final ObjectMapper objectMapper;


    @Override
    public Schedule create(Schedule schedule) {
        try {
            CloudSchedulerClient client = CloudSchedulerClient.create();

            String parent = LocationName.of(projectId, location).toString();

            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Google-Cloud-Scheduler");
            headers.put("Content-Type", "application/json; charset=utf-8");

            HttpTarget httpTarget = HttpTarget.newBuilder()
                    .setUri(httpTargetUri)
                    .setHttpMethod(HttpMethod.PUT)
                    .putAllHeaders(headers)
                    .setBody(ByteString.copyFromUtf8(getJobBody(schedule)))
                    .build();

            Job job = Job.newBuilder()
                    .setName(trainingJobName)
                    .setDescription("test java job")
                    .setSchedule("* * * * *")
                    .setTimeZone("America/Sao_Paulo")
                    .setHttpTarget(httpTarget)
                    .build();

            client.createJob(parent, job);
            client.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    private String getJobBody(Schedule schedule) throws JSONException {
        return objectMapper.writeValueAsString(schedule);

//        JSONObject jobBody = new JSONObject();
//        jobBody.put("id", schedule.getId());
//        jobBody.put("objectUUID", UUID.randomUUID().toString());
//
//        return jobBody.toString();
    }

}
