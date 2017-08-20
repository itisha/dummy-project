package org.tisha.mockito;

/**
 * Created by t on 14.08.2017.
 */
public class GreetingImpl implements Greeting {

    @Override
    public String greet(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name should be provided.");
        }
        return "Hello " + name;
    }
}
