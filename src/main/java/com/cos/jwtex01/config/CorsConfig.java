package com.cos.jwtex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOrigin("*"); // e.g. http://domain1.com
      config.addAllowedHeader("*"); //Access-Control-Request-Headers
      config.addAllowedMethod("*"); //put delete  post 허용하는 것

      source.registerCorsConfiguration("/**", config); //모든 주소에 다 이 설정이 
      return new CorsFilter(source);
   }

}
