package com.myKidGoal.tenant;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties
public class MultitenancyConfiguration {

    private static final String TENANT_FOLDER = "tenant";

    @Bean(name = "multitenantProvider")
    public DataSourceBasedMultiTenantConnectionProviderImpl dataSourceBasedMultiTenantConnectionProvider()
            throws IOException {
        HashMap<String, DataSource> dataSources = new HashMap<String, DataSource>();

        String pathString = this.getClass().getClassLoader().getResource(TENANT_FOLDER).getPath();
        File tenantDirectory = new File(pathString);

        String defaultTenant = null;

        for (File file : tenantDirectory.listFiles()) {
            Properties prop = new Properties();
            InputStream inputStream = new FileInputStream(file);
            prop.load(inputStream);

            DataSource dataSource = DataSourceBuilder.create()
                    .driverClassName(prop.getProperty("multitenant.driverClassName"))
                    .username(prop.getProperty("multitenant.username"))
                    .password(prop.getProperty("multitenant.password")).url(prop.getProperty("multitenant.url"))
                    .build();

            String name = prop.getProperty("multitenant.name");

            boolean isDefault = Boolean.parseBoolean(prop.getProperty("multitenant.default"));

            if (isDefault) {
                defaultTenant = name;
            }

            dataSources.put(name, dataSource);
        }

        return new DataSourceBasedMultiTenantConnectionProviderImpl(defaultTenant, dataSources);
    }

    @Bean
    @DependsOn("multitenantProvider")
    public DataSource defaultDataSource() throws IOException {
        return dataSourceBasedMultiTenantConnectionProvider().getDefaultDataSource();
    }

}
