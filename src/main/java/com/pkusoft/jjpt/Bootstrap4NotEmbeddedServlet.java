package com.pkusoft.jjpt;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * springboot运行在非内置web容器时的启动程序
 */
public class Bootstrap4NotEmbeddedServlet extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Bootstrap.class);
    }
}
