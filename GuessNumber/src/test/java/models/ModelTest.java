package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ModelTest {
    private static final int SECRET_NUMBER = 30;
    private static final int HIGHER_LIMIT = 101;
    private static final int LOWER_LIMIT = 0;

    private Model model = new Model();

    @Before
    public void settingOfLimits() {
        model.settingOfLimits(Limits.MIN_LIMIT.getValue(), Limits.MAX_LIMIT.getValue());
        model.setCorrectAnswer(SECRET_NUMBER);
    }

    @Test
    public void tryToGuessAnswerWhenAnswerIsCorrect() {
        model.guessAnswer(SECRET_NUMBER);

        assertFalse(model.isNotSecretNumber());
    }

    @Test
    public void isNotNumberGuessed() {
        model.guessAnswer(20);

        assertTrue(model.isNotSecretNumber());
    }

    @Test
    public void isOutOfLimitsHigher() {
        boolean actual = model.isOutOfLimits(HIGHER_LIMIT);

        assertTrue(actual);
    }

    @Test
    public void isOutOfLimitsLower() {
        boolean actual = model.isOutOfLimits(LOWER_LIMIT);

        assertTrue(actual);
    }

}