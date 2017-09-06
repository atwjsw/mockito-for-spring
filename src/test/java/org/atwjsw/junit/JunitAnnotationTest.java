package org.atwjsw.junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by wenda on 9/4/2017.
 */
@RunWith(JUnit4.class)
public class JunitAnnotationTest {

    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("running beforeClass\n");
    }

    @Before
    public void testBefore() {
        System.out.println("running before");
    }

    @Test
    public void testMethod1() {
        System.out.println("running test method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("running test method 2");
    }

    @Test
    public void testMethod3() {
        System.out.println("running test method 3");
    }

    @After
    public void testAfter() {
        System.out.println("running after");
    }

    @AfterClass
    public static void testAfterClass() {
        System.out.println("running AfterClass");
    }
}
