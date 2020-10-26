package com.dudu.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UserConfig {
    @NacosValue("${spring.datasource.url}")
    private String url;

    @NacosValue("${spring.datasource.username}")
    private String username;

    @NacosValue("${spring.datasource.password}")
    private String password;

    @Primary
    @Bean
    public DataSourceProperties dataSourceProperties() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl(url);
        dataSourceProperties.setPassword(password);
        dataSourceProperties.setUsername(username);
        return dataSourceProperties;
    }
}
