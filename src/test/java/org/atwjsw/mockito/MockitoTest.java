package org.atwjsw.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by wenda on 9/4/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    List<String> mockedList;

    @Test
    public void test_mock_verfiy() {
//        List<String> mockedList = mock(List.class);
        mockedList.add("andrew");
        verify(mockedList, only()).add("andrew");
        mockedList.add("jonathan");
        mockedList.add("jonathan");
        mockedList.add("michelle");

        verify(mockedList).add("andrew");
        verify(mockedList, times(2)).add("jonathan");

        when(mockedList.get(0)).thenReturn("daniel");
        System.out.println(mockedList.get(0));
        assertThat(mockedList.get(0), is("daniel"));
        assertEquals("daniel", mockedList.get(0));
//        mockedList.get(1);
        verify(mockedList, times(3)).get(anyInt());
        verify(mockedList, atLeastOnce()).get(anyInt());
        verify(mockedList, atLeast(3)).get(0);
        verify(mockedList, atMost(4)).get(0);
        verify(mockedList, times(0)).get(1);
        verify(mockedList, never()).get(1);

        System.out.println(mockedList.get(1));
        verify(mockedList, times(1)).get(1);
    }

    @Test(expected = RuntimeException.class)
//    @Test
    public void test_mock_when_return() {
        mockedList.add("andrew");
        mockedList.add("jonathan");
        mockedList.add("jonathan");
        mockedList.add("michelle");

        when(mockedList.get(0)).thenReturn("daniel");
        System.out.println(mockedList.get(0));
        assertThat(mockedList.get(0), is("daniel"));
        when(mockedList.get(1)).thenThrow(RuntimeException.class);
        mockedList.get(1);
        when(mockedList.get(2)).thenCallRealMethod();
        System.out.println(mockedList.get(2));
        doThrow(RuntimeException.class).when(mockedList).clear();
        mockedList.clear();
    }

    @Test(expected = RuntimeException.class)
    public void test_verify_interaction() {
        verifyZeroInteractions(mockedList);
        mockedList.add("andrew");
        verify(mockedList).add("andrew");
        verifyNoMoreInteractions(mockedList);
    }

    @Test(expected = Exception.class)
//    @Test
    public void test_custom_answer() {
        when(mockedList.get(4)).thenAnswer(new CustomAnswer());
        when(mockedList.get(3)).thenAnswer(new CustomAnswer());
        System.out.println(mockedList.get(4));
        System.out.println(mockedList.get(3));
//        doAnswer(new CustomAnswer()).when(mockedList.get(3));
    }

}
