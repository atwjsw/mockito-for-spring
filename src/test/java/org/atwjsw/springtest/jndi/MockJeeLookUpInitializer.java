package org.atwjsw.springtest.jndi;

import org.mockito.Mockito;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by wenda on 9/5/2017.
 */
public class MockJeeLookUpInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        DataSource mockDataSource = Mockito.mock(javax.sql.DataSource.class);
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
        builder.bind("java:comp/env/Datasource", mockDataSource);
        try {
            builder.activate();
        } catch (IllegalStateException | NamingException e) {
            e.printStackTrace();
        }
    }
}
