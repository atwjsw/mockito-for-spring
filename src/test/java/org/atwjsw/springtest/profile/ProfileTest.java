package org.atwjsw.springtest.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by wenda on 9/5/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:org.atwjsw.profile/applicationContext.xml")
@ActiveProfiles({"dev"})
public class ProfileTest {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void testDevProfile() {
        String message = (String) ctx.getBean("message");
        String noProfile = (String) ctx.getBean("noProfileBean");
        System.out.println(message);
        System.out.println(noProfile);
//        assertEquals("I'm a dev bean", message);
        assertEquals("I'm a prod bean", message);
        assertEquals("I'm a free bean", noProfile);
    }

    @Test
    @Timed(millis=2000)
    public void test_timed() throws InterruptedException {
        Thread.sleep(5000);
//        System.out.println("test finished");
    }

    @Repeat(100)
    @Test
    public void testToBeRepeated() {
        System.out.println("repeated");
    }
}
