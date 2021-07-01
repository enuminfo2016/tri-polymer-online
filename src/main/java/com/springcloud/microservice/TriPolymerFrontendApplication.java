/**
 * 
 */
package com.springcloud.microservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.ResourceUtils;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.springcloud.microservice.util.EnvironmentEnum;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SIVA KUMAR
 */
@SpringBootApplication
@EnableSwagger2
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TriPolymerFrontendApplication extends SpringBootServletInitializer implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TriPolymerFrontendApplication.class);
    private Model model;
    @Autowired ApplicationContext applicationContext;
    @Autowired Environment environment;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TriPolymerFrontendApplication.class);
        app.setDefaultProperties(getDefaultProperties());
        app.run(args);
	}
	
    protected static final Properties getDefaultProperties() {
        Properties props = new Properties();
        return props;
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getClass());
    }

	@Override
	public void run(String... args) throws Exception {
		log.info("TriPolymerFrontendApplicationTest.CommandLineRunner.run() -> {}", args.length);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);
	}

	private CharacterEncodingFilter encodingFilter() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return encodingFilter;
	}

	@Bean
	public FilterRegistrationBean encodingFilterBean() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(encodingFilter());
		filterBean.addUrlPatterns("/*");
		filterBean.setName("encodingFilter");
		return filterBean;
	}

    @Bean
	public Docket applicationApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData())
				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

    private ApiInfo metaData() {
        try {
            model = new MavenXpp3Reader().read(new FileReader("pom.xml"));
        } catch (IOException | XmlPullParserException e) {
            log.error("TriPolymerFrontendApplicationTest.metaData() -> {}", e.getMessage());
        }
        return new ApiInfo(model.getName(), model.getDescription(), model.getVersion(), "Terms of service",
                new Contact("EI Team", "https://enuminfo.com/", "enuminfo2016@gmail.com"), "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
	}
    
    private ApiKey apiKey() { 
        return new ApiKey("JWT", "Authorization", "header"); 
    }

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) throws SQLException, FileNotFoundException {
		log.info("TriPolymerFrontendApplicationTest.dataSourceInitializer() - Catalog -> {}", dataSource.getConnection().getCatalog());
		log.info("TriPolymerFrontendApplicationTest.dataSourceInitializer() - Driver Name -> {}", dataSource.getConnection().getMetaData().getDriverName());
		log.info("TriPolymerFrontendApplicationTest.dataSourceInitializer() - Driver Version -> {}", dataSource.getConnection().getMetaData().getDriverVersion());
		log.info("TriPolymerFrontendApplicationTest.dataSourceInitializer() - Driver URL -> {}", dataSource.getConnection().getMetaData().getURL());
		log.info("TriPolymerFrontendApplicationTest.dataSourceInitializer() - Driver User -> {}", dataSource.getConnection().getMetaData().getUserName());
		EnvironmentEnum activeEnv = EnvironmentEnum.valueOf(environment.getActiveProfiles()[0].toUpperCase());
		log.info("Active Profile : {}", activeEnv.name());
		File dbMigrateFiles = ResourceUtils.getFile("classpath:db/migrate/");
		File[] listOfFiles = dbMigrateFiles.listFiles();
		Arrays. sort(listOfFiles);
		DataSourceInitializer dataSourceInitializer = null;
		for (File file : listOfFiles) {
			log.info("=============== validating {} in {} ===============", file.getName(), activeEnv.name());
			if (!activeEnv.name().equalsIgnoreCase(EnvironmentEnum.PROD.name())  
					&& !activeEnv.name().equalsIgnoreCase(EnvironmentEnum.QA.name())
					&& !activeEnv.name().equalsIgnoreCase(EnvironmentEnum.STAGE.name())) {
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
