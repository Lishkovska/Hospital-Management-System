package com.example.hospitalmanagementsystem.config;

import com.example.hospitalmanagementsystem.service.MaintenanceCustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private final MaintenanceCustomInterceptor maintenanceCustomInterceptor;

    public WebConfiguration(MaintenanceCustomInterceptor maintenanceCustomInterceptor) {
        this.maintenanceCustomInterceptor = maintenanceCustomInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(maintenanceCustomInterceptor);
     //   WebMvcConfigurer.super.addInterceptors(registry);
    }
}
