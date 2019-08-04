package com.myKidGoal.tenant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TenantInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public MyTenantInterceptor myTenantInterceptor() {
        return new MyTenantInterceptor();
    }

    public @Override void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myTenantInterceptor()).addPathPatterns("/**");
    }

}
