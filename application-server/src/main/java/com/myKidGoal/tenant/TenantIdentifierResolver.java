package com.myKidGoal.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getCurrentTenant();
        if (tenantId != null) {
            return tenantId;
        }
        return TenantContext.getDefaultTenant();
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
