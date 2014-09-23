package exceptionquiz.plugin.exception.question;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Правильный ответ "Нет".
 */
class NoAnswer extends AbstractAnswer {
    private static final NoAnswer INSTANCE = new NoAnswer();

    public NoAnswer() {
        variants.add("no");
        variants.add("n");
        variants.add("нет");
        variants.add("н");
    }

    public static NoAnswer getInstance() {
        return INSTANCE;
    }
}