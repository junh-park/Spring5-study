package com.jun.tacos;


import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@SpringBootApplication(scanBasePackages = "com.jun")
@EntityScan("com.jun")
@EnableJpaRepositories(basePackages = "com.jun.tacos.data")
@ConfigurationPropertiesScan(basePackages = { "com.jun.tacos" })
public class TacoServiceCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoServiceCloudApplication.class, args);
	}
}
