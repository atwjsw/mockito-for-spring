package org.atwjsw.junit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenda on 9/4/2017.
 */
public class JunitAssertTest {

    @Test
    public void assert_boolean_conditions() {
        assertTrue(100 > 0);
        assertTrue("0 is greater than 100", 100 > 0);
        assertFalse(0 > 100);
        assertFalse("0 is greater than 100", 0 > 100);
    }

    @Test
    public void assert_null_conditions() {
        Object obj1 = new Object();
        Object obj2 = null;
        assertNotNull(obj1);
        assertNotNull("obj is not null", obj1);
        assertNull(obj2);
        assertNull("obj is null", obj2);
    }

    @Test
    public void assert_equals_or_same() {
        Employee employee1 = new Employee("1", "andrew");
        Employee employee2 = new Employee("2", "jonathan");
        Employee employee3 = new Employee("1", "andrew");
        Employee employee4 = employee2;
        Employee employee5 = employee4;
        System.out.println("employee1: " + employee1);
        assertNotEquals(employee1, employee2);
        assertEquals(employee1, employee3);
        assertNotSame(employee1, employee3);
        assertSame(employee2, employee5);
    }

    @Test
    public void assert_equals_double() {
        assertNotEquals(9.99, 10.01);
        assertEquals(9.99, 9.99, 0.00000000000000000000000001);
    }

//    @Test(expected = RuntimeException.class)
    @Test(expected = Exception.class)
    public void expected() {
       throw new RuntimeException();
    }


}
