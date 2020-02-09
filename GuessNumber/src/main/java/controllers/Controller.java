package controllers;

import models.Limits;
import models.Model;

import java.util.List;

public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public List<Integer> getAnswers() {
        return model.getAnswers();
    }

    public void settingOfLimits(Limits bottomLimit, Limits topLimit) {
        model.settingOfLimits(bottomLimit.getValue(), topLimit.getValue());
    }

    public int getLowerLimit() {
        return model.getLowerLimit();
    }

    public int getUpperLimit() {
        return model.getUpperLimit();
    }

    public void guessAnswer(int answer) {
        model.guessAnswer(answer);
    }

    public boolean isNotSecretNumber() {
        return model.isNotSecretNumber();
    }

    public boolean isOutOfLimits(int answer) {
        return model.isOutOfLimits(answer);
    }
}
