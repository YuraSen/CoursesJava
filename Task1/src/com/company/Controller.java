package com.company;

import java.util.Scanner;

public class Controller {

    public static final String FIRST_STRING = "Hello";
    public static final String SECOND_STRING = "Java";

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);

        view.printMessage(View.INPUT_HELLO);
        String firstWord = inputString(scanner, FIRST_STRING);
        model.setFirstString(firstWord);

        view.printMessage(View.INPUT_JAVA);
        String secondWord = inputString(scanner, SECOND_STRING);
        model.setSecondString(secondWord);

        view.printAllMessage(model.createMessage());
    }

    private String inputString(Scanner scanner, String word) {
        while (!scanner.hasNext(word)) {
            view.printMessage(View.WRONG_INPUT_DATA);
            scanner.next();
        }
        return scanner.next();
    }
}
