package com.grocery.properties;

import com.grocery.interceptor.GroceryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

}
