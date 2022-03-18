package com.enuminfo.cloud;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.util.ResourceUtils;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.enuminfo.cloud.util.EnvironmentEnum;

import io.r2dbc.spi.ConnectionFactory;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableWebFlux
@EnableR2dbcRepositories
@SuppressWarnings("deprecation")
@OpenAPIDefinition(info = @Info(title = "TriPolymer Online", 
	version = "0.0.1-SNAPSHOT", 
	description = "ENUMInfo | Spring Cloud MicroService - Tri Polymer Online Service"))
public class TriPolymerOnlineApplication {
    @Autowired Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(TriPolymerOnlineApplication.class, args);
	}
	
	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) throws FileNotFoundException {
		ConnectionFactoryInitializer connectionFactoryInitializer = new ConnectionFactoryInitializer();
		connectionFactoryInitializer.setConnectionFactory(connectionFactory);
		CompositeDatabasePopulator compositeDatabasePopulator = new CompositeDatabasePopulator();
		EnvironmentEnum activeEnv = EnvironmentEnum.valueOf(environment.getActiveProfiles()[0].toUpperCase());
		log.info("Active Profile : {}", activeEnv.name());
		if (activeEnv.name().equalsIgnoreCase(EnvironmentEnum.DEVELOPMENT.name())) {
			File dbMigrateFiles = ResourceUtils.getFile("classpath:db/migrate/");
			File[] listOfFiles = dbMigrateFiles.listFiles();
			Arrays.sort(listOfFiles);
			for (File file : listOfFiles) {
				compositeDatabasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("/db/migrate/" + file.getName())));
				connectionFactoryInitializer.setDatabasePopulator(compositeDatabasePopulator);
				log.info("=============== processing {} in {} ===============", file.getName(), activeEnv.name());
			}
		}
		return connectionFactoryInitializer;
	}
}
