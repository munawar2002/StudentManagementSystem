package com.myKidGoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackageClasses = {
        StudentManagementApplication.class }, exclude = DataSourceAutoConfiguration.class)
@EntityScan(basePackageClasses = { StudentManagementApplication.class })
@EnableJpaRepositories(basePackageClasses = { StudentManagementApplication.class })
// Enables stuff like EntityManagerFactoryBuilder to be created for us.
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}
