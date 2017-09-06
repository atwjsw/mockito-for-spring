package org.atwjsw.mockito;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Created by wenda on 9/4/2017.
 */
public class CustomAnswer implements Answer<String> {
    public String answer(InvocationOnMock invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        Integer num = (Integer)args[0];
        if( num>3 ){
            return "yes";
        } else {
            throw new RuntimeException();
        }
    }
}
