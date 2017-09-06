package org.atwjsw.springtest.env;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by wenda on 9/5/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=EnvConfig.class)
//@ContextConfiguration(classes=EnvConfig.class, initializers = MockPropertyEnvInitializer.class)
@ContextConfiguration(classes=EnvConfig.class, initializers = MockPropertySourceInitializer.class)
public class EnvTest {
    @Autowired
    Environment env;

    @Autowired
    ApplicationContext ctx;

    @Test
    public void testEnv() {
        String msg = env.getProperty("message");
        String test = env.getProperty("test" , "I am a queen");
        System.out.println(msg);
        System.out.println(test);
    }

    @Test
    public void testEnv2() {
        String messageBean = (String) ctx.getBean("message");
        String msg = messageBean.toString();
        System.out.println(msg);
//        assertEquals("I'm the king", ctx.getBean("message"));
        assertEquals("I'm a mockstar", ctx.getBean("message"));
    }



}
