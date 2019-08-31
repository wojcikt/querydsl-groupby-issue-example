package com.example.demo;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.codegen.MetaDataExporter;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    SQLQueryFactory queryFactory(DataSource dataSource) {
        final H2Templates templates = new H2Templates();

        final Configuration configuration = new Configuration(templates);
        configuration.setExceptionTranslator(new SpringExceptionTranslator());

        final SpringConnectionProvider connectionProvider = new SpringConnectionProvider(dataSource);
        return new SQLQueryFactory(configuration, connectionProvider);
    }

}
