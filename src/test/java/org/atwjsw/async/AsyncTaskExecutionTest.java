package org.atwjsw.async;

/**
 * Created by wenda on 9/3/2017.
 */

import org.atwjsw.async.AccountJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:org/atwjsw/async/applicationContext.xml")
public class AsyncTaskExecutionTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void jobTest() throws Exception {
        AccountJob job = context.getBean(AccountJob.class);
        job.process();
        System.out.println("job executed");
    }
}
