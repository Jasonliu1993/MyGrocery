package com.grocery.configuration;

import com.grocery.Messagehandler.InstationSenderProviderFactory;
import com.grocery.Messagehandler.CoreSender;
import com.grocery.interceptor.GroceryCoreInterceptor;
import com.grocery.webSocket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.servlet.ServletRequestListener;

/**
 * Created by Jason on 14/10/2017.
 */

@Configuration
public class GroceryConfiguration extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    @Autowired
    private GroceryCoreInterceptor groceryCoreInterceptor;

    @Autowired
    private CustomProperty customProperty;

    @Autowired
    private WebSocketHandler webSocketHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(groceryCoreInterceptor);
        super.addInterceptors(registry);
    }

    @Bean
    public ServletRequestListener createServletRequestListener(){
        return new RequestContextListener();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    //    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
        return resolver;
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new DruidStatViewServlet(),"/druid/*");

        servletRegistrationBean.setInitParameters(customProperty.getDruidConfig());

        return servletRegistrationBean;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
            webSocketHandlerRegistry.addHandler(webSocketHandler,"");

    }

    @Bean(name = "coreSender")
    public CoreSender getProviderBuilder() {
        CoreSender providerBuilder = new CoreSender();

        providerBuilder.addProviderFactories("instatioinSenderProviderFactory",new InstationSenderProviderFactory());

        return providerBuilder;
    }
}
