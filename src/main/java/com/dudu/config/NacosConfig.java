package com.dudu.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "${NACOSADDR}", namespace = "dev"))
@NacosPropertySource(dataId = "dudu.yml", groupId = "dudu-group", autoRefreshed = true)
public class NacosConfig {
    
}
