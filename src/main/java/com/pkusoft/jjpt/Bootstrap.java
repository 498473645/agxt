package com.pkusoft.jjpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot启动程序
 */
// 参考https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-auto-configuration.html
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.support.pkubatis","com.pkusoft","com.pkusoft.usercenterproxy"})
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    // 跨域，对被shiro过滤的请求无效
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
