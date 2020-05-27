package com.moofarm.wallet;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.moofarm.wallet.repository")
public class JpaConfig {
}
