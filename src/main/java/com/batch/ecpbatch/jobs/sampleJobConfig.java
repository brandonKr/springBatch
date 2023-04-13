package com.batch.ecpbatch.jobs;

import com.batch.ecpbatch.tasklets.tutorialTasklet;
import com.batch.ecpbatch.tasklets.tutorialTasklet2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class sampleJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job sampleJob(){
        return jobBuilderFactory.get("sampleJob")
                .start(tutorialStep3())
                .build();
    }

    @Bean
    public Step tutorialStep3(){
        return stepBuilderFactory.get("tutorialStep")
                .tasklet(new tutorialTasklet2())
                .build();
    }
}
