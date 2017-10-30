package com.grocery.configuration;

import com.grocery.interceptor.GroceryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletRequestListener;

/**
 * Created by Jason on 14/10/2017.
 */

@Component
public class GroceryConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    private GroceryInterceptor groceryInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(groceryInterceptor);
    }

    @Bean
    public ServletRequestListener createServletRequestListener(){
        return new RequestContextListener();
    }

}
