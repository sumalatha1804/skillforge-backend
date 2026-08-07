package com.skillforge.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public String securityBean() {
        return "SkillForge Security Enabled";
    }

}