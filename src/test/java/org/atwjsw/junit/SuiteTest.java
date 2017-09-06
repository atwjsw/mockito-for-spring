package org.atwjsw.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by wenda on 9/4/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JunitAssertTest.class, JunitAnnotationTest.class})
public class SuiteTest {
}
