//package com.restaurant.lesson1.config;
//
//import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring6.view.ThymeleafViewResolver;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.restaurant.lesson1")
//public class AppConfig {
//
//    @Bean
//    public SpringResourceTemplateResolver springResourceTemplateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setPrefix("/WEB-INF/templates/");
//        resolver.setSuffix(".html");
//        resolver.setCharacterEncoding("UTF-8");
//        resolver.setTemplateMode("HTML");
//        return resolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine springTemplateEngine() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(springResourceTemplateResolver());
//        engine.addDialect(new LayoutDialect()); // thêm layout dialect
//        return engine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(springTemplateEngine());
//        resolver.setCharacterEncoding("UTF-8");
//        return resolver;
//    }
//}