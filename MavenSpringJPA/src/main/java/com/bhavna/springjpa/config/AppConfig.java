package com.bhavna.springjpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.bhavna.springjpa"})
public class AppConfig implements WebMvcConfigurer {
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	            .addResourceHandler("/resources/**")
	            .addResourceLocations("/resources/");
	    }

}
