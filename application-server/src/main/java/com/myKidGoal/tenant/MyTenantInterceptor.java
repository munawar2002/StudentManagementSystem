package com.myKidGoal.tenant;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class MyTenantInterceptor implements HandlerInterceptor {

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
        String pathString = this.getClass().getClassLoader().getResource("tenant/testDB.properties").getPath();
        File file = new File(pathString);
        Properties prop = new Properties();
        InputStream inputStream = new FileInputStream(file);
        prop.load(inputStream);

        String devTenantName = prop.getProperty("multitenant.name");

        if (StringUtils.isNotBlank(devTenantName)) {
            return devTenantName;
        }

        return clientTenantName;
    }

}
