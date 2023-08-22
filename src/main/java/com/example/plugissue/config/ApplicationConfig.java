package com.example.plugissue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.example.plugissue.user"})
@Import({DBConfig.class})
public class ApplicationConfig {
}
