package com.comfort.sponsorshiphub.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

@Configuration
@Log4j2
public class AwsConfig {

    @Value("${aws.access-key}")
    private String accessKey;

   @Value("${aws.secret-key}")
    private String secretKey;
    //@Value("${aws.region}")
    private String region;

    @Bean
    public BasicAWSCredentials basicAWSCredentials(){
        log.info(accessKey);

        log.info(secretKey);
        return
                new BasicAWSCredentials(accessKey,secretKey);
    }
    @Bean
    public AmazonS3 amazonS3(){
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials()))
                .build();
    }

    //@PostConstruct
    public void addPhoto() throws URISyntaxException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL resource = classloader.getResource("log.png");
        File file = new File(resource.toURI().getPath());
        if(!amazonS3().doesBucketExistV2("sponsor-new")){
            Bucket sponsor = amazonS3().createBucket("sponsor-new");
        }

      amazonS3().listBuckets().forEach((b)-> System.out.println(b.getName()));

        amazonS3().putObject("sponsor-new",file.getName(), file);


    }







}
