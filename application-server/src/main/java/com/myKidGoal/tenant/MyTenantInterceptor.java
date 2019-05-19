package com.myKidGoal.tenant;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyTenantInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.print("\\n\\nIn MyInterceptor.preHandle\\n\\n");
        String tenant = request.getParameter("tenant");

        if (StringUtils.isBlank(tenant)) {
            throw new Exception("Invalid User Id or Password. Please try again.");
        } else {
            TenantContext.setCurrentTenant(tenant);
        }

        return true;
    }

}
