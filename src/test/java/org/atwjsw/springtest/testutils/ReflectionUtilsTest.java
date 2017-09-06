package org.atwjsw.springtest.testutils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by wenda on 9/5/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ReflectionUtilsTest {
    @Test
    public void private_field_access() throws Exception {
        Secret myClass = new Secret();
        myClass.initiate("aio");
        Field secretField = ReflectionUtils.findField(Secret.class,"secret", String.class);
        assertNotNull(secretField);
        ReflectionUtils.makeAccessible(secretField);
        assertEquals("zko", ReflectionUtils.getField(secretField, myClass));
        ReflectionUtils.setField(secretField, myClass, "cool");
        assertEquals("cool", ReflectionUtils.getField(secretField, myClass));
    }

}
