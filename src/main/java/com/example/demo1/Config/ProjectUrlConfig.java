package com.example.demo1.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("purl")
@Data
public class ProjectUrlConfig {
    public String domain;
}
