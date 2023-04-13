package com.batch.ecpbatch.schedulers;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;



@Component
@RequiredArgsConstructor
public class tutorialScheduler {

    @Autowired
    private JobRegistry jobRegistry;
    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(){
        JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
        postProcessor.setJobRegistry((jobRegistry));
        return postProcessor;
    }

    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 20000)
    public void executeTutorialJob(){

        try {
            jobLauncher.run(
                    jobRegistry.getJob("tutorialJob"),
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .toJobParameters()
            );
        }catch (JobExecutionException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    @Scheduled(fixedDelay = 10000)
    public void executeSampleJob(){

        try {
            jobLauncher.run(
                    jobRegistry.getJob("sampleJob"),
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .toJobParameters()
            );
        }catch (JobExecutionException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


}
