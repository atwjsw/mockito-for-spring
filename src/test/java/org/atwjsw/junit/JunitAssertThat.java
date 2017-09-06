package org.atwjsw.junit;

import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.atwjsw.junit.LessThanOrEqual.lessThanOrEqual;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by wenda on 9/4/2017.
 */
public class JunitAssertThat {

    @Test
    public void testAssertThat_is_not_equalTo() {
        String str1 = "andrew";
        String str2 = new String("andrew");
        String str3 = "jonathan";
        assertEquals(str1, str2);
        assertNotSame(str1, str2);
        assertThat(str1, is(str2));
        assertThat(str1, equalTo(str2));
        assertThat(str1, not(sameInstance(str2)));
        assertThat(str1, not(theInstance(str2)));
        assertThat(str1, isA(String.class));
        assertThat(str1, isA(Object.class));
        assertThat(str1, isA(Serializable.class));
        assertThat("3", is("3"));
        assertThat("andrew", is(not("Jonathan")));
        assertThat("andrew", not(is("Jonathan")));
        assertThat("andrew", not(equalTo("Jonathan")));
        assertThat("andrew", is(equalTo("andrew")));
        assertThat("andrew", is("andrew"));
        assertThat("andrew", equalTo("andrew"));
        assertThat("andrew", instanceOf(String.class));
        assertThat("andrew", instanceOf(Object.class));
        assertThat("andrew", instanceOf(Comparable.class));
        assertThat("andrew", not(instanceOf(Integer.class)));

    }

    @Test
    public void testAssertThat_nullValue() {
        Integer three = 3;
        Integer four = null;
        assertThat(three, notNullValue());
        assertThat(four, nullValue());
    }

    @Test
    public void testAssertThat_either_or_both() {
        String str1 = "andrew";
        String str2 = "michelle";
        String str3 = "jonathan";
        assertThat("andrew", either(is(str1)).or(is(str3)));
        assertThat("andrew", both(not(str2)).and((not(str3))));
        assertThat("andrew", anyOf(is(str1), is(str2), is(str3)));
        assertThat("daniel", not(anyOf(is(str1), is(str2), is(str3))));
        assertThat("andrew", allOf(is(str1), is("andrew"), is("andrew")));
    }

    @Test
    public void testAssertThat_has_items() {
        String str1 = "andrew";
        String str2 = "michelle";
        String str3 = "jonathan";
        List<String> names = Arrays.asList(str1, str2, str3);
        assertThat(names, hasItem(str1));
        assertThat(names, not(hasItem("daniel")));
        assertThat(names, hasItems(str1, str2));
        assertThat(names, not(hasItems(str1, "daniel")));
        assertThat(names, any(List.class));
        assertThat(names, any(Collection.class));
        assertThat(names, anything("daniel"));
        assertThat(names, everyItem(isA(String.class)));
        assertThat(names, everyItem(not(is("daniel"))));
    }

    @Test
    public void testAssertThat_describeAs() {
        BigDecimal myBigDecimal = new BigDecimal("99.99");
        describedAs("a big decimal equal to %0", equalTo(myBigDecimal), myBigDecimal.toPlainString());
    }

    @Test
    public void testAssertThat_startsWith() {
        String str1 = "andrew wen";
        String str2 = "michelle deng";
        String str3 = "jonathan wen";
        assertThat(str1, startsWith("and"));
        assertThat(str1, endsWith("wen"));
        assertThat(str3, containsString("jonathan"));
    }

    @Test
    public void lessthanOrEquals_matcher() throws Exception {
        assertThat(99, lessThanOrEqual(new Integer(100)));
        assertThat("abc", lessThanOrEqual("abd"));
        int maxInt = Integer.MAX_VALUE;
        assertThat(maxInt, lessThanOrEqual(Integer.MIN_VALUE));
    }
}
