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

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class LaunchTriPolymerOnlineApplication {
	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(LaunchTriPolymerOnlineApplication.class, args);
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) throws SQLException, FileNotFoundException {
		log.info("LaunchTriPolymerOnlineApplication.dataSourceInitializer() - Catalog -> {}", dataSource.getConnection().getCatalog());
		log.info("LaunchTriPolymerOnlineApplication.dataSourceInitializer() - Driver Name -> {}", dataSource.getConnection().getMetaData().getDriverName());
		log.info("LaunchTriPolymerOnlineApplication.dataSourceInitializer() - Driver Version -> {}", dataSource.getConnection().getMetaData().getDriverVersion());
		log.info("LaunchTriPolymerOnlineApplication.dataSourceInitializer() - Driver URL -> {}", dataSource.getConnection().getMetaData().getURL());
		log.info("LaunchTriPolymerOnlineApplication.dataSourceInitializer() - Driver User -> {}", dataSource.getConnection().getMetaData().getUserName());
		EnvironmentEnum activeEnv = EnvironmentEnum.valueOf(environment.getActiveProfiles()[0].toUpperCase());
		log.info("Active Profile : {}", activeEnv.name());
		File dbMigrateFiles = ResourceUtils.getFile("classpath:db/migrate/");
		File[] listOfFiles = dbMigrateFiles.listFiles();
		Arrays. sort(listOfFiles);
		DataSourceInitializer dataSourceInitializer = null;
		for (File file : listOfFiles) {
			log.info("=============== validating {} in {} ===============", file.getName(), activeEnv.name());
			if (!activeEnv.name().equalsIgnoreCase(EnvironmentEnum.PERFORMANCE.name())
					&& !activeEnv.name().equalsIgnoreCase(EnvironmentEnum.PRODUCTION.name())) {
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
}
