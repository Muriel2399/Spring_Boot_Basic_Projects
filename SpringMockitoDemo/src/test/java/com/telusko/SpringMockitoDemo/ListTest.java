package com.telusko.SpringMockitoDemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
     void simpleTest() {
      List mock1= mock(List.class);
      when(mock1.size()).thenReturn(5);
      assertEquals(5, mock1.size());
      assertEquals(5, mock1.size());
    }
    @Test
    void multipleReturns() {
        List mock1= mock(List.class);
        when(mock1.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock1.size());
        assertEquals(10, mock1.size());
    }
    @Test
    void specific_parameters() {
        List mock1= mock(List.class);
        when(mock1.get(0)).thenReturn("Some String");
        assertEquals("Some String",mock1.get(0));
        assertEquals(null,mock1.get(1));
    }
    @Test
    void generic_parameters() {
        List mock1= mock(List.class);
        when(mock1.get(Mockito.anyInt())).thenReturn("Some Other String");
        assertEquals("Some Other String",mock1.get(0));
        assertEquals("Some Other String",mock1.get(1));
        assertEquals("Some Other String",mock1.get(2));
    }
}
