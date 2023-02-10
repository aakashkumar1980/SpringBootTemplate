package com.java.aadityadesigners.bootstrap.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@EntityScan({"com.java.aadityadesigners.services"})
@EnableJpaRepositories("com.java.aadityadesigners.services")
@PropertySources({
    @PropertySource(
        value="classpath:datasource/datasource.yml", 
        factory= YamlPropertyLoaderFactory.class
    ), 
    @PropertySource(
        value="classpath:datasource/datasource-${spring.profiles.active}.yml", 
        factory= YamlPropertyLoaderFactory.class
    )
})
public class DataSourceConfig {

}