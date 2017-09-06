package org.atwjsw.springtest.jndi;

/**
 * Created by wenda on 9/5/2017.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:org.atwjsw.jndi/applicationContext.xml",
        initializers =  MockJeeLookUpInitializer.class)
public class DataSourceTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void testMock_JNDI_DataSource() {
        assertNotNull(context.getBean("common-Datasource"));
    }


}
