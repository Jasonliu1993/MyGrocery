package com.grocery.configuration;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Driver;

/**
 * Created by Jason on 21/10/2017.
 * 此处可以读取配置文件的参数，放入DruidDataSource中，但是这里没有配置
 */
@Configuration
public class DruidDataSourceConfig {

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("{spring.datasource.url}")
    private String url;

    @Value("{spring.datasource.username}")
    private String username;

    @Value("{spring.datasource.password}")
    private String password;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


}