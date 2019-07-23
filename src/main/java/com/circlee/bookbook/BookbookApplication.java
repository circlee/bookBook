package com.circlee.bookbook;

import com.circlee.bookbook.config.ServerConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableFeignClients
@EnableConfigurationProperties(ServerConfigProperties.class)
@SpringBootApplication
public class BookbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookbookApplication.class, args);
    }

}
