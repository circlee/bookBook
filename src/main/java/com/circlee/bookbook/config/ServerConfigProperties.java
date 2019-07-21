package com.circlee.bookbook.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "server-config")
public class ServerConfigProperties {

    private String apiRoot;

}
