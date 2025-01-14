package com.bmarques.springs3csv;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

//    public AWSCredentials credentials() {
//        AWSCredentials credentials = new BasicAWSCredentials(
//                "accesskey",
//                "secretkey"
//        );
//        return credentials;
//    }

    @Bean
    public AmazonS3 amazonS3() {

        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .build();

    }
}