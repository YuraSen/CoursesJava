package models;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertFalse;

public class ModelTest {
    private static final int SECRET_NUMBER = 50;

    private static final Model model = new Model();

    @BeforeAll
    static void settingOfLimits() {
        model.settingOfLimits(Limits.MAX_LIMIT.getValue(), Limits.MIN_LIMIT.getValue());
        model.guessAnswer(SECRET_NUMBER);
    }

    @Test
    public void tryToGuessAnswer() {
        model.guessAnswer(SECRET_NUMBER);

       // assertFalse(model.guessAnswer(guesed));

    }

    @Test
    public void isNotNumberGuessed() {
    }

    @Test
    public void isOutOfLimits() {
    }
}