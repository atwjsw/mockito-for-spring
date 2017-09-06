package org.atwjsw.springtest.env;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.env.MockEnvironment;

/**
 * Created by wenda on 9/5/2017.
 */
public class MockPropertyEnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        MockEnvironment mock = new MockEnvironment();
        mock.setProperty("message", "I'm a mockstar");
        applicationContext.setEnvironment(mock);
    }
}