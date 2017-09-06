package org.atwjsw.junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * Created by wenda on 9/4/2017.
 */
public class LessThanOrEqual<T extends Comparable<T>> extends BaseMatcher<Comparable<T>> {
    private final Comparable<T> expValue;
    public LessThanOrEqual(T expValue) {
        this.expValue= expValue;
    }
    @Override
    public void describeTo(Description desc) {
        desc.appendText(" less than or equal(<=)" + expValue);
    }
    @Override
    public boolean matches(Object t) {
        int compareTo = expValue.compareTo((T)t);
        return compareTo > -1;
    }

    @Factory
    public static<T extends Comparable<T>> Matcher<T> lessThanOrEqual(T t) {
        return new LessThanOrEqual(t);
    }
}
