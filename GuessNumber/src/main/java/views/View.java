package views;

import controllers.Controller;
import models.Limits;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class View {

    private static final String GREETING_MESSAGE = "Try to guess a number! Number is between 0 and 100";
    private static final String INPUT_NUMBER = "Please, enter a INT number : ";
    private static final String WRONG_INPUT = "Please, try again. Input a number which enters the limit!";
    private static final String WRONG_INPUT_OUT_OF_LIMIT = "Number is out of limits!";

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void startGame() {
        printMessage(View.GREETING_MESSAGE);
        controller.settingOfLimits(Limits.MIN_LIMIT, Limits.MAX_LIMIT);

        int guessedNumber = secretNumber();
        printSecretNumber(guessedNumber);
        printAllAnswers(controller.getAnswers());
    }


    private int inputIntValue(Scanner scanner) {
        printLimits(controller.getLowerLimit(), controller.getUpperLimit());
        printMessage(View.INPUT_NUMBER);
        while (!scanner.hasNextInt()) {
            printMessage(View.WRONG_INPUT);
            printMessage(View.INPUT_NUMBER);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int secretNumber() {
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            answer = inputIntValue(scanner);
            attemptsToGuessTheNumber(answer);
        } while (controller.isNotSecretNumber());
        return answer;
    }

    private void attemptsToGuessTheNumber(int answer) {
        if (controller.isOutOfLimits(answer)) {
            printMessage(WRONG_INPUT_OUT_OF_LIMIT);
        } else {
            controller.guessAnswer(answer);
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printLimits(int bottom, int top) {
        printMessage(String.format("Number in this limits: ]%d...%d[", bottom, top));
    }

    private void printSecretNumber(int number) {
        printMessage(String.format("My congratulations, you WIN! The secret number was: %d", number));
    }

    private void printAllAnswers(List<Integer> answers) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        answers.forEach(answer -> joiner.add(answer.toString()));
        printMessage(String.format("Sequence of your answers: %s", joiner.toString()));
    }
}
