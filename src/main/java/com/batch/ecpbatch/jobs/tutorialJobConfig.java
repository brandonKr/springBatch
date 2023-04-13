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
public class tutorialJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job tutorialJob(){
        return jobBuilderFactory.get("tutorialJob")
                .start(tutorialStep())
                .next(tutorialStep2())
                .build();
    }

    @Bean
    public Step tutorialStep(){
        return stepBuilderFactory.get("tutorialStep")
                .tasklet(new tutorialTasklet())
                .build();
    }


    @Bean
    public Step tutorialStep2(){
        return stepBuilderFactory.get("tutorialStep2")
                .tasklet(new tutorialTasklet2())
                .build();
    }
}
