package com.myKidGoal.tenant;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@Component
public class MyTenantInterceptor implements HandlerInterceptor {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String tenant = getTenantName(request.getParameter("tenant"));

        if (request.getRequestURI().contains("swagger")) {
            return true;
        }

        if (StringUtils.isBlank(tenant)) {
            throw new Exception("Invalid User Id or Password. Please try again.");
        } else {
            TenantContext.setCurrentTenant(tenant);
        }

        return true;
    }

    private String getTenantName(String clientTenantName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:tenant/testDB.properties");
        Properties prop = new Properties();
        prop.load(resource.getInputStream());
        String devTenantName = prop.getProperty("multitenant.name");

        if (StringUtils.isNotBlank(devTenantName)) {
            return devTenantName;
        }

        return clientTenantName;
    }

}
