package per.msb.til.lessons.jan.wk4.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver<String> {
    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = AppTenantContext.getCurrentTenant();
        return Objects.requireNonNullElse(tenant, "public");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
