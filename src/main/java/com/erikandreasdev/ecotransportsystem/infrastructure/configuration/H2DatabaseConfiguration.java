package com.erikandreasdev.ecotransportsystem.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("h2")
public class H2DatabaseConfiguration {

    public H2DatabaseConfiguration() {
        System.out.println("h2 - configuration");
    }

}
