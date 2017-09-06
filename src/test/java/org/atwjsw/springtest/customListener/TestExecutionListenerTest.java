package org.atwjsw.springtest.customListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wenda on 9/5/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org.atwjsw.springtest/applicationContext.xml")
@TestExecutionListeners(listeners = SysOutTestExecutionListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
//@TestExecutionListeners(listeners = SysOutTestExecutionListener.class)
public class TestExecutionListenerTest {

    @Test
    public void someTest() throws Exception {
        System.out.println("executing someTest");
    }
    @Test
    public void someOtherTest() throws Exception {
        System.out.println("executing someOtherTest");
    }

}
