package com.company;

public class Model {

    private String firstString;
    private String secondString;

    public String createMessage() {
        return firstString + " " +  secondString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    public String getFirstString() {
        return firstString;
    }

    public void setSecondString(String secondString) {
        this.secondString = secondString;
    }

    public String getSecondString() {
        return secondString;
    }
}
