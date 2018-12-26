package com.qasystem.config;

import com.qasystem.interceptor.AskInterceptor;
import com.qasystem.interceptor.ManageInterceptor;
import com.qasystem.interceptor.UnreadUpdateInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        super.addViewControllers(registry);
    }

    @Bean
    public UnreadUpdateInterceptor unreadUpdateInterceptor(){
        return new UnreadUpdateInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ManageInterceptor()).addPathPatterns("/manage");
        registry.addInterceptor(new AskInterceptor()).addPathPatterns("/ask");
        registry.addInterceptor(unreadUpdateInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/register");
        super.addInterceptors(registry);
    }
}
