package com.example.devlog;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final JobLauncher jobLauncher;
    private final JobRegistry jobRegistry;

    @GetMapping("/test")
    public String firstApi() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder()
                .toJobParameters();

        jobLauncher.run(jobRegistry.getJob("exampleJob"), jobParameters);

        return "ok";
    }
}
