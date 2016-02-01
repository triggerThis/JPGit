package sample.web.ui;

import javax.annotation.Resources;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.web.controller")

//public class MvcConfig extends WebMvcConfigurerAdapter {
public class MvcConfig extends WebMvcConfigurerAdapter  {  
  
    
  //  @Override
  //  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
  //      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   // }
     
}