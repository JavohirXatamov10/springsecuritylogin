package org.example.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class Chain extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}
