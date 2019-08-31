package com.example.demo;

import com.querydsl.sql.codegen.MetaDataExporter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;

@Component
public class QueryDslGenerator implements ApplicationRunner {

    private final DataSource dataSource;

    public QueryDslGenerator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!args.containsOption("generate-querydsl")) {
            return;
        }

        try (final Connection connection = DataSourceUtils.getConnection(dataSource)) {
            final MetaDataExporter exporter = new MetaDataExporter();
            exporter.setPackageName("com.example.demo.querydsl");
            exporter.setTargetFolder(new File("src/main/java"));
            exporter.export(connection.getMetaData());
        }
    }

}
