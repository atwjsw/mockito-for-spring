package org.atwjsw.springtest.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * Created by wenda on 9/5/2017.
 */
@Configuration
@PropertySource("classpath:org/atwjsw/env/app.properties")
public class EnvConfig {
    @Resource
    private Environment environment;

    @Bean(name="message")
    public String getMessage() {
        return environment.getProperty("message");
    }
}
