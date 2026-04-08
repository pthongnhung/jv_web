package org.example.session04.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Danh dau la lop cau hinh
@Configuration
//Bat che do web mvc
@EnableWebMvc
//Quet cac bean can duoc khoi tao
@ComponentScan(basePackages = "org.example.session04")

public class AppConfig  {
//    Cau hinh bean ViewResolver de doc duoc view
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

//        Cau hinh tien to
        viewResolver.setPrefix("/WEB-INF/views/");
//        Cau hinh hau to
        viewResolver.setSuffix(".jsp");
        return viewResolver;

    }
}
