package com.myKidGoal.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        return TenantContext.getCurrentTenant() != null ? TenantContext.getCurrentTenant()
                : TenantContext.getDefaultTenant();
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
