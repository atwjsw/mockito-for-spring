package org.atwjsw.springtest.customListener;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by wenda on 9/5/2017.
 */
public class SysOutTestExecutionListener implements TestExecutionListener {
    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        System.out.println("beforeTestClass " + testContext.getTestClass().getName());
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        System.out.println("prepareTestInstance " + testContext.getTestClass().getName());
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.out.println("beforeTestMethod " + testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        System.out.println("afterTestMethod " + testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        System.out.println("afterTestClass " + testContext.getTestClass().getName());
    }
}
