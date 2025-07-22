package org.practice.config;

import org.practice.aop.CustomAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {

    @Bean
    public CustomAspect myAspect() {
        return new CustomAspect();
    }
}

