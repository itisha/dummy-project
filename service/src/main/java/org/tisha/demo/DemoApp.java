package org.tisha.demo;

/**
 * @author Tsikhan Kuprevich
 * @since 7/31/2017
 */
public class DemoApp {

    public static void main(String[] args) {
        System.out.println("|++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        if (args.length == 0) {
            System.out.println("|    Hello, I'm created by apache maven! ");
        } else {
            System.out.println("|    Args passed in: " + args[0]);
        }
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
