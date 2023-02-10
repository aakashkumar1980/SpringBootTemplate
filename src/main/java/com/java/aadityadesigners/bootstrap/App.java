package com.java.aadityadesigners.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages={"com.java.aadityadesigners"})
@PropertySources(value = { 
	@PropertySource("classpath:application-${spring.profiles.active}.yml")
})
public class App {

	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
	
}