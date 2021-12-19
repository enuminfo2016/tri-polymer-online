package com.enuminfo.cloud;

import com.enuminfo.cloud.util.EnvironmentEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.ResourceUtils;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
@SpringBootApplication
@EnableSwagger2
public class LaunchTriPolymerOnlineApplication {
	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(LaunchTriPolymerOnlineApplication.class, args);
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) throws SQLException, FileNotFoundException {
		EnvironmentEnum activeEnv = EnvironmentEnum.valueOf(environment.getActiveProfiles()[0].toUpperCase());
		log.info("Active Profile : {}", activeEnv.name());
		File dbMigrateFiles = ResourceUtils.getFile("classpath:db/migrate/");
		File[] listOfFiles = dbMigrateFiles.listFiles();
		Arrays. sort(listOfFiles);
		DataSourceInitializer dataSourceInitializer = null;
		for (File file : listOfFiles) {
			log.info("=============== validating {} in {} ===============", file.getName(), activeEnv.name());
			if (!activeEnv.name().equalsIgnoreCase(EnvironmentEnum.PROD.name())) {
				dataSourceInitializer = new DataSourceInitializer();
				dataSourceInitializer.setDataSource(dataSource);
				ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
				resourceDatabasePopulator.addScript(new ClassPathResource("/db/migrate/" + file.getName()));
				dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
				log.info("=============== processing {} in {} ===============", file.getName(), activeEnv.name());
				resourceDatabasePopulator.execute(dataSource);
			}
		}
		return dataSourceInitializer;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("TriPolymer Online API", "ENUMInfo | TriPolymer Online API Framework",
				"0.0.1-SNAPSHOT", "Terms of service",
				new Contact("ENUMInfo Team", "www.enuminfo.com", "enuminfo2016@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.enuminfo.cloud"))
				.paths(PathSelectors.ant("/api/*")).build().apiInfo(apiInfo());
	}
}
