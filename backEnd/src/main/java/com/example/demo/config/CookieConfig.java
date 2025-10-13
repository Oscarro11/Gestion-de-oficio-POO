package com.example.demo.config;

import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CookieConfig{

    @Bean
    public CookieSameSiteSupplier applicationCookieSameSiteSupplier() {
        // Allow cross-origin on localhost without requiring HTTPS
        return CookieSameSiteSupplier.ofLax().whenHasName("JSESSIONID");
    }
}