package com.company;

public class View {

    public static final String INPUT_HELLO = "Input Hello: ";
    public static final String INPUT_JAVA = "Input Java: ";
    public static final String WRONG_INPUT_DATA = "Input wrong! Please try again!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printAllMessage(String result) {
        printMessage("Result: " + result);
    }
}
