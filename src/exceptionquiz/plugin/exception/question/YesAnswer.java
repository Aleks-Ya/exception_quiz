package exceptionquiz.plugin.exception.question;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Правильный ответ "Да".
 */
class YesAnswer extends AbstractAnswer {
    private static final YesAnswer INSTANCE = new YesAnswer();

    private YesAnswer() {
        variants.add("yes");
        variants.add("y");
        variants.add("да");
        variants.add("д");
    }

    public static YesAnswer getInstance() {
        return INSTANCE;
    }
}