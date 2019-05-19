package com.myKidGoal.tenant;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackageClasses = PortfolioRepository.class , entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "dbTransactionManager")
public class DatabaseConfiguration {

    // @Value("spring.datasource.username")
    // private String userName;
    //
    // @Value("spring.datasource.password")
    // private String password;
    //
    // @Primary
    // @Bean
    // public DataSourceProperties createDataSourceProperties(){
    //
    // DataSourceProperties dataSourceProperties = new DataSourceProperties();
    // dataSourceProperties.setUsername("root");
    // dataSourceProperties.setPassword("str0ng");
    // String property = System.getProperty("tenant.name");
    // if(property == null){
    // property = "login";
    // }
    // String url = "jdbc:mysql://localhost:8080/"+ property +"?useSSL=true";
    // dataSourceProperties.setUrl(url);
    // dataSourceProperties.setDriverClassName("com.mysql.jdbc.Driver");
    // return dataSourceProperties;
    // }
    //
    // @Primary
    // @Bean
    // public DataSource setDataSource(@Qualifier("createDataSourceProperties") DataSourceProperties
    // dataSourceProperties){
    // return dataSourceProperties.initializeDataSourceBuilder().build();
    // }
    //
    // @Bean
    // public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("setDataSource") DataSource
    // dataSource, EntityManagerFactoryBuilder builder){
    // return builder.dataSource(dataSource).packages(Asset.class).build();
    // }
    //
    // @Primary
    // @Bean
    // public PlatformTransactionManager dbTransactionManager(EntityManagerFactory factory){
    // return new JpaTransactionManager(factory);
    // }
}
