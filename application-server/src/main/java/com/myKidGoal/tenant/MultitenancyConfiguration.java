package com.myKidGoal.tenant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties
public class MultitenancyConfiguration {

    private static final String TENANT_FOLDER = "tenant/*";

    private static final Logger logger = LoggerFactory.getLogger(MultitenancyConfiguration.class);

    @Value("classpath:" + TENANT_FOLDER)
    private Resource[] resources;

    @Bean(name = "multitenantProvider")
    public DataSourceBasedMultiTenantConnectionProviderImpl dataSourceBasedMultiTenantConnectionProvider()
            throws IOException {
        HashMap<String, DataSource> dataSources = new HashMap<String, DataSource>();

        logger.info("--- Total tenants are [" + resources.length + "]");

        String defaultTenant = null;

        for (Resource resource : resources) {
            logger.info("Tenant file name [" + resource.getFilename() + "]");
            Properties prop = new Properties();
            prop.load(resource.getInputStream());

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
