package org.tisha.mockito;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by t on 14.08.2017.
 */
public class GreetingImplTest {

    @Test
    public void testGreet() throws Exception {
        GreetingImpl greeting = new GreetingImpl();
        String result = greeting.greet("Junit");
        assertNotNull(result);
        assertEquals("Hello Junit", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowExceptionForNullInput() {
        GreetingImpl greeting = new GreetingImpl();
        greeting.greet("");
    }
}