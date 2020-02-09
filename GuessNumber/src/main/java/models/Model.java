package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private int secretNumber;
    private final List<Integer> answers = new ArrayList<>();
    private int bottomLimit;
    private int topLimit;

    public void settingOfLimits(int lowerLimit, int upperLimit) {
        setLowerLimit(lowerLimit);
        settingOfLimits(upperLimit);
        generateGuessNumber();
    }

    private void generateGuessNumber() {
        secretNumber = new Random().nextInt(topLimit - 1) + bottomLimit + 1;
    }

    void setCorrectAnswer(int correctAnswer) {
        this.secretNumber = correctAnswer;
    }


    private void settingOfLimits(int limit) {
        topLimit = limit;
    }

    private void setLowerLimit(int limit) {
        bottomLimit = limit;
    }

    private void addAnswer(int answer) {
        answers.add(answer);
    }

    public int getUpperLimit() {
        return topLimit;
    }

    public int getLowerLimit() {
        return bottomLimit;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void guessAnswer(int answer) {
        addAnswer(answer);
        if (answer != secretNumber) {
            updateLimits(answer);
        }
    }

    private void updateLimits(int answer) {
        if (answer > secretNumber) {
            settingOfLimits(answer);
        } else {
            setLowerLimit(answer);
        }
    }

    public boolean isNotSecretNumber() {
        return !answers.contains(secretNumber);
    }

    public boolean isOutOfLimits(int answer) {
        return answer >= getUpperLimit() || answer <= getLowerLimit();
    }
}
